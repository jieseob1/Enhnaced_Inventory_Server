// data source & all connection configuration

import { DataSource } from "typeorm";
// https://levelup.gitconnected.com/datasource-in-typeorm-a-new-way-to-connect-to-your-database-cdc6622f9bbc

export const dataSource  =new DataSource({
  type: 'postgres',
  host: process.env.PG_HOST,
  port: process.env.PG_PORT as any,
  username: process.env.PG_USER,
  password: process.env.PG_PASSWORD,
  // synchronize, // what is that
  // logging // what is that

})
// // to initialize initial connection with the database, register all entities
// and "synchronize" database schema, call "initialize()" method of a newly created database
// once in your application bootstrap