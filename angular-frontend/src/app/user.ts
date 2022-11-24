export class User {
    find(arg0: (a: User) => boolean) {
      throw new Error('Method not implemented.');
    }

    id!: string;
    firstName!: string;
    lastName!: string;
    email!: string;
    password!: string;
}
