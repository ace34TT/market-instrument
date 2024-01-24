CREATE TABLE "instruments" (
    "id" serial NOT NULL,
    "name" varchar NOT NULL,
    "type" integer NOT NULL,
    "category" integer NOT NULL,
    "preview" varchar NOT NULL,
    CONSTRAINT "instruments_pk" PRIMARY KEY ("id")
) WITH (OIDS = FALSE);
CREATE TABLE "instrument_types" (
    "id" serial NOT NULL,
    "name" varchar NOT NULL,
    CONSTRAINT "instrument_types_pk" PRIMARY KEY ("id")
) WITH (OIDS = FALSE);
CREATE TABLE "instrument_categories" (
    "id" serial NOT NULL,
    "name" varchar NOT NULL,
    "level" integer UNIQUE NOT NULL,
    CONSTRAINT "instrument_categories_pk" PRIMARY KEY ("id")
) WITH (OIDS = FALSE);
CREATE TABLE "prices" (
    "id" serial NOT NULL,
    "created_at" DATE NOT NULL,
    "price" FLOAT NOT NULL,
    "instrument_id" integer NOT NULL,
    CONSTRAINT "prices_pk" PRIMARY KEY ("id")
) WITH (OIDS = FALSE);
CREATE TABLE "users" (
    "id" serial NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "role" VARCHAR(255) NOT NULL,
    CONSTRAINT "users_pk" PRIMARY KEY ("id")
) WITH (OIDS = FALSE);
CREATE TABLE "purchases" (
    "id" serial NOT NULL,
    "instrument_id" integer NOT NULL,
    "quantity" integer NOT NULL,
    "price" FLOAT NOT NULL,
    "user_id" integer NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    CONSTRAINT "purchases_pk" PRIMARY KEY ("id")
) WITH (OIDS = FALSE);
ALTER TABLE "instruments"
ADD CONSTRAINT "instruments_fk0" FOREIGN KEY ("type") REFERENCES "instrument_types"("id");
ALTER TABLE "instruments"
ADD CONSTRAINT "instruments_fk1" FOREIGN KEY ("category") REFERENCES "instrument_categories"("id");
ALTER TABLE "prices"
ADD CONSTRAINT "prices_fk0" FOREIGN KEY ("instrument_id") REFERENCES "instruments"("id");
ALTER TABLE "purchases"
ADD CONSTRAINT "purchases_fk0" FOREIGN KEY ("instrument_id") REFERENCES "instruments"("id");
ALTER TABLE "purchases"
ADD CONSTRAINT "purchases_fk1" FOREIGN KEY ("user_id") REFERENCES "users"("id");