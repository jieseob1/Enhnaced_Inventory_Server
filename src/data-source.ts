import { DataSource } from "typeorm";

// data source and all connection configuration
// change host,username,password,databse, port options
export const AppDataSource = new DataSource({
  type: "postgres",
  host: "localhost",
  username: "test",
  password: "test",
  database: "test", //change to env later
  synchronize: true,
  logging: true,
  entities: [],
  subscribers: [],
  migrations: [],
});