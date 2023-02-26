package com.vlm.shop.ServiceImpl;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vlm.shop.Constents.ShopConstants;
import com.vlm.shop.Dao.BillDao;
import com.vlm.shop.Entity.Bill;
import com.vlm.shop.Jwt.JwtFilter;
import com.vlm.shop.Service.BillService;
import com.vlm.shop.Utils.ShopUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	BillDao billDao;

	@Override
	public ResponseEntity<String> generateReport(Map<String, Object> requestMap) {
		log.info("generateReport");
		try {
			String fileName;
			if (validateRequestMap(requestMap)) {
				if (requestMap.containsKey("isGenerate") && !(Boolean) requestMap.get("isGenerate")) {
					fileName = (String) requestMap.get("uuid");
				} else {
					fileName = ShopUtils.getUUID();
					requestMap.put("uuid", fileName);
					insertBill(requestMap);
				}
				
				String data = "Name: "+ requestMap.get("name") +"\n"+"Contact Number: "+requestMap.get("contatNumber")+
						"\n"+"Email: "+ requestMap.get("email") +"\n"+"Payment Method: "+requestMap.get("paymentMethod");
				
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(ShopConstants.STORE_LOCATION + "\\" +fileName + ".pdf"));
				
				document.open();
				setRectangleInPdf(document);
				
				Paragraph chunk = new Paragraph("Shop Management System", getFont("Header"));
				chunk.setAlignment(Element.ALIGN_CENTER);
				document.add(chunk);
				
				Paragraph paragraph = new Paragraph(data + "\n \n", getFont("Data"));
				document.add(paragraph);
				
				PdfPTable table = new PdfPTable(5);
				table.setWidthPercentage(100);
				addTableHeader(table);
				
				JSONArray jsonArray = ShopUtils.getJsonArrayFromString((String) requestMap.get("productDetails"));
				for (int i = 0; i < jsonArray.length(); i++) {
					addRows(table, ShopUtils.getMapFromJson(jsonArray.getString(i)));
				}
				document.add(table);
				
				Paragraph footer = new Paragraph("Total : "+requestMap.get("totalAmount")+"\n"
						+"Thank you for visiting. Please visit again!", getFont("Data"));
				document.add(footer);
				document.close();
				return new ResponseEntity<>("{\"uuid\":\"" + fileName + "\"}", HttpStatus.OK);
				
				
			}
			return ShopUtils.getResponseEntity("Requred data not found", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ShopUtils.getResponseEntity(ShopConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private void addRows(PdfPTable table, Map<String, Object> data) {
		log.info("Inside addRows");
		table.addCell((String) data.get("name"));
		table.addCell((String) data.get("category"));
		table.addCell((String) data.get("quantity"));
		table.addCell(Double.toString((Double) data.get("price")));
		table.addCell(Double.toString((Double) data.get("total")));
	}

	private void addTableHeader(PdfPTable table) {
		log.info("Inside addTableHeader");
		Stream.of("Name","Category","Quantity","Price","Su Total")
		.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			header.setBackgroundColor(BaseColor.YELLOW);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(header);
		});
	}

	private Font getFont(String type) {
		log.info("Inside getFont");
		switch (type) {
		case "Header":
			Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 18, BaseColor.BLACK);
			headerFont.setStyle(Font.BOLD);
			return headerFont;
		case "Data":
			  Font dataFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, BaseColor.BLACK);
			  dataFont.setStyle(Font.BOLD);
			  return dataFont;
			  default:
				  return new Font();
	}
}

	private void setRectangleInPdf(Document document) throws DocumentException {
		log.info("Inside setRectangleInPdf");
		Rectangle rect = new Rectangle(577, 825, 18, 15);
		rect.enableBorderSide(1);
		rect.enableBorderSide(2);
		rect.enableBorderSide(2);
		rect.enableBorderSide(8);
		rect.setBackgroundColor(BaseColor.BLACK);
		rect.setBorderWidth(1);
		document.add(rect);
	}

	private void insertBill(Map<String, Object> requestMap) {
		try {
			Bill bill = new Bill();
			bill.setUuid((String) requestMap.get("bill"));
			bill.setName((String) requestMap.get("name"));
			bill.setEmail((String)requestMap.get("email"));
			bill.setContactNumber((String) requestMap.get("contactName"));
			bill.setPaymentMethod((String) requestMap.get("paymentMethod"));
			bill.setTotal(Integer.parseInt((String) requestMap.get("totalAmount")));
			bill.setProductDetail((String) requestMap.get("productDetails"));
			bill.setCreatedBy(jwtFilter.getCurrentUser());
			billDao.save(bill);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	private boolean validateRequestMap(Map<String, Object> requestMap) {
		return requestMap.containsKey("name") &&
				requestMap.containsKey("name") &&
				requestMap.containsKey("contactNumber") &&
				requestMap.containsKey("paymentMethod") &&
				requestMap.containsKey("productDetails") &&
				requestMap.containsKey("totalAmount");
	}

}
