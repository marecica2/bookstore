export class User {
    id: number;
    login: string;
    firstName: string;
    lastName: string;

    constructor( id?: number, login?: string, firstName?: string, lastName?: string ) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}