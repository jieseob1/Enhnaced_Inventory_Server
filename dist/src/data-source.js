"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.AppDataSource = void 0;
const typeorm_1 = require("typeorm");
// data source and all connection configuration
// change host,username,password,databse, port options
exports.AppDataSource = new typeorm_1.DataSource({
    type: "postgres",
    host: "localhost",
    username: "test",
    password: "test",
    database: "test",
    synchronize: true,
    logging: true,
    entities: [],
    subscribers: [],
    migrations: [],
});
//# sourceMappingURL=data-source.js.map