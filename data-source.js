"use strict";
// data source & all connection configuration
Object.defineProperty(exports, "__esModule", { value: true });
exports.AppDataSource = void 0;
const typeorm_1 = require("typeorm");
// https://levelup.gitconnected.com/datasource-in-typeorm-a-new-way-to-connect-to-your-database-cdc6622f9bbc
exports.AppDataSource = new typeorm_1.DataSource({
    type: 'postgres',
    host: process.env.PG_HOST,
    port: process.env.PG_PORT,
    username: process.env.PG_USER,
    password: process.env.PG_PASSWORD,
    // synchronize, // what is that
    // logging // what is that
});
// // to initialize initial connection with the database, register all entities
// and "synchronize" database schema, call "initialize()" method of a newly created database
// once in your application bootstrap
exports.AppDataSource.initialize()
    .then(() => {
    console.log("Data Source has been initialized");
    // here you can start to work with your database
})
    .catch((error) => console.log(error));
//# sourceMappingURL=data-source.js.map