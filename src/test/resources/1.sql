/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2019/1/24 19:38:29                           */
/*==============================================================*/


DROP TABLE DD_ADDRESS CASCADE CONSTRAINTS;

DROP TABLE DD_BOOK CASCADE CONSTRAINTS;

DROP TABLE DD_CART CASCADE CONSTRAINTS;

DROP TABLE DD_MANAGE CASCADE CONSTRAINTS;

DROP TABLE DD_ORDER CASCADE CONSTRAINTS;

DROP TABLE DD_ORDER_DETAILS CASCADE CONSTRAINTS;

DROP TABLE DD_TYPE CASCADE CONSTRAINTS;

DROP TABLE DD_USER CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: DD_ADDRESS                                            */
/*==============================================================*/
CREATE TABLE D_ADRESS  (
   ID                   VARCHAR(36)                     NOT NULL,
   NAME       VARCHAR(36),
   ADDRESS    VARCHAR(300),
   ZIP_CODE             VARCHAR(6),
   PHONE         VARCHAR(11),
   USER_ID              VARCHAR(36),
   CONSTRAINT PK_D_ADDRESS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: DD_BOOK                                               */
/*==============================================================*/
CREATE TABLE D_BOOK  (
   ID                   VARCHAR(36)                     NOT NULL,
   NAME                 VARCHAR(36),
   CATEGORY_ID          VARCHAR(36),
   PRICE                NUMBER(9,2),
   DD_PRICE             NUMBER(9,2),
   STOCK            NUMBER(9),
   AUTHOR               VARCHAR(40),
   PRESS                VARCHAR(40),
   EDITION              VARCHAR(40),
   PUBLISH_DATE          DATE,
   PRINT_DATE           DATE,
   PRINT_TIME          VARCHAR(36),
   ISBN                 VARCHAR(40),
   FORMAT               NUMBER(4),
   PAPER                NUMBER(4),
   PACK                 VARCHAR(36),
   PAGE_NUM               NUMBER(9),
   FONT_NUM                 NUMBER(9),
   COVER                VARCHAR(100),
   RECOMMENDATION              VARCHAR(100),
   SUMMARY              VARCHAR(100),
   RESUME               VARCHAR(100),
   CATALOG              VARCHAR(100),
   MEDIA                VARCHAR(100),
   SALAS                NUMBER(9),
   CONSTRAINT PK_D_BOOK PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: DD_CART                                               */
/*==============================================================*/
CREATE TABLE DD_CART  (
   ID                   VARCHAR(36)                     NOT NULL,
   USER_ID              VARCHAR(36),
   BOOK_ID              VARCHAR(36),
   "NUMBER"             NUMBER,
   CONSTRAINT PK_DD_CART PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: DD_MANAGE                                             */
/*==============================================================*/
CREATE TABLE D_ADMIN  (
   ID                   VARCHAR(36)                     NOT NULL,
   USERNAME             VARCHAR(36),
   PASSWORD             VARCHAR(36),
   CONSTRAINT PK_DD_MANAGE PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: DD_ORDER                                              */
/*==============================================================*/
CREATE TABLE D_ORDER  (
   ID                   VARCHAR(36)                     NOT NULL,
   TOTAL                NUMBER(8,2),
   STATUS               CHAR(1),
   CREATE_DATE          DATE,
   ORDER_NUMBER         VARCHAR(36),
   ADDRESS_ID              VARCHAR(36),
   USER_ID              VARCHAR(36),
   CONSTRAINT PK_D_ORDER PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: DD_ORDER_DETAILS                                      */
/*==============================================================*/
CREATE TABLE D_ITEM  (
   ID                   VARCHAR(36)                     NOT NULL,
   ORDER_ID             VARCHAR(36),
   COUNTS               NUMBER(9),
   BOOK_ID              VARCHAR(36),
   CREATE_DATE          DATE,
   CONSTRAINT PK_D_ITEM PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: DD_TYPE                                               */
/*==============================================================*/
CREATE TABLE DD_TYPE  (
   ID                   VARCHAR(36)                     NOT NULL,
  NAME            VARCHAR(36),
   PARENT        VARCHAR(36),
   LEVEL          CHAR(1),
   CONSTRAINT PK_DD_TYPE PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: DD_USER                                               */
/*==============================================================*/
CREATE TABLE D_USER  (
   ID                   VARCHAR(36)                     NOT NULL,
   NICKNAME             VARCHAR(36),
   PASSWORD             VARCHAR(36),
   EMAIL                VARCHAR(36),
   STATUS               CHAR(1),
   CODE      VARCHAR(8),
   CONSTRAINT PK_DD_USER PRIMARY KEY (ID)
);

