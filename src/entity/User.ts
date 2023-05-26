import { Entity } from "typeorm";

// initialization
@Entity()
export class User {
  id: number
  name: string
}