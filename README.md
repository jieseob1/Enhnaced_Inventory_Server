# Enhnaced_Inventory_Server
From Build up make more structured Server than before and For ERP System


## As a Stack

* serverless: Framework for building serverless applications.

* TypeORM: Object-relational mapping library for TypeScript and JavaScript.

* PostgreSQL: Open-source relational database management system. -> (also check about aws RDS)

* Redis: In-memory data structure store used as a database, cache, and message broker.

* Elasticsearch: Search and analytics engine for all types of data.

* Koa: Lightweight web framework for Node.js.(using Nodemon)



AWS Services
* Lambda: Compute service that lets you run code without provisioning or managing servers.
* SES: Email service that lets you send and receive email using your own email addresses and domains.
* API Gateway: Fully managed service that makes it easy for developers to create, publish, maintain, monitor, and secure APIs.
* S3: Object storage service that offers industry-leading scalability, data availability, security, and performance.
* CloudFront: Content delivery network (CDN) that securely delivers data, videos, applications, and APIs to customers globally with low latency, high transfer speeds, and no minimum usage commitments.


### Docker Tutorial
https://github.com/docker/getting-started

## initial ERD(1.0V)

      +-----------------+
      |   Organization  |
      +-----------------+
      | organization_id |
      | name            |
      | address         |
      | phone           |
      | ...             |
      +-----------------+
              |
              |
              |
      +-------+--------+
      |   Department   |
      +----------------+
      | department_id  |
      | name           |
      | manager_id     |
      | ...            |
      +----------------+
              |
              |
              |
      +-------+--------+
      |    Employee    |
      +----------------+
      | employee_id    |
      | first_name     |
      | last_name      |
      | email          |
      | phone          |
      | hire_date      |
      | job_title      |
      | department_id  |
      | ...            |
      +----------------+
              |
              |
              |
      +-------+--------+
      |    Customer    |
      +----------------+
      | customer_id    |
      | first_name     |
      | last_name      |
      | email          |
      | phone          |
      | address        |
      | ...            |
      +----------------+
              |
              |
              |
      +-------+--------+
      |    Supplier    |
      +----------------+
      | supplier_id    |
      | name           |
      | email          |
      | phone          |
      | address        |
      | ...            |
      +----------------+
              |
              |
              |
      +-------+--------+
      |    Product     |
      +----------------+
      | product_id     |
      | name           |
      | description    |
      | price          |
      | quantity       |
      | ...            |
      +----------------+
              |
              |
              |
      +-------+--------+
      |    Order       |
      +----------------+
      | order_id       |
      | order_date     |
      | customer_id    |
      | total_amount   |
      | ...            |
      +----------------+
              |
              |
              |
      +-------+--------+
      |   OrderItem    |
      +----------------+
      | orderitem_id   |
      | order_id       |
      | product_id     |
      | quantity       |
      | unit_price     |
      | ...            |
      +----------------+
              |
              |
              |
      +-------+--------+
      |   Warehouse    |
      +----------------+
      | warehouse_id   |
      | name           |
      | location       |
      | ...            |
      +----------------+
              |
              |
              |
      +-------+--------+
      |   Inventory    |
      +----------------+
      | inventory_id   |
      | warehouse_id   |
      | product_id     |
      | quantity       |
      | ...            |
      +----------------+


## Issue Handling

### Docker
1. 
Q: failed to solve with frontend dockerfile.v0: failed to read dockerfile: open /var/lib/docker/tmp/buildkit-mount2368062799/Dockerfile: no such file or directory
A: add `DOCKER_BUILD KIT=0` at the prefix when docker build
ex: DOCKER_BUILDKIT=0 docker build  -t enhanced-inventory-server .

2. 
Q: Error response from daemon: Cannot locate specified Dockerfile: Dockerfile
A: DockerFile => Dockerfile

3. 도커 이미지 빌드하는 방법
DOCKER_BUILDKIT=0 docker build -t enhanced-inventory-server .
docker run -p 4000:4000 enhanced-inventory-server