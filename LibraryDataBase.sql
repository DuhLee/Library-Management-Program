/* 
     ������ ���� ���α׷� DB
     
     * TABLE ���
     
     - admins                 ������ ���� ����
     - members                ȸ�� ����
     - books                  ��������
     - locations              ���� ��ġ ����
     - check_out_info         ���� ����
     - readingroom            ������ ����
     - seat_use_details       ������ ��볻��
     - image_information      ���α׷��� ���Ǵ� �̹��� ����
     
     * SEQUENCE
          
     - admin_num_seq          ������ ��ȣ
     - mem_num_seq            ȸ�� ��ȣ
     - book_id_seq            ��� ��ȣ
     - check_out_id_seq       ���⳻�� ���̵� 
     - user_detail_id_seq     ������ �¼� ��볻�� ���̵�
     
*/
SELECT * FROM tabs;
SELECT * FROM user_sequences;

-- ������ ���� ���� ���̺�
CREATE TABLE admins(
     admin_num      NUMBER(11)  CONSTRAINT ad_ad_num_pk  PRIMARY KEY,      -- ��� ��ȣ  PK
     admin_name     VARCHAR2(255)  CONSTRAINT ad_ad_name_nn NOT NULL,      -- ��� �̸�
     admin_pw       VARCHAR2(255)  CONSTRAINT ad_ad_pw_nn NOT NULL,        -- ��� ��й�ȣ
     admin_phone    VARCHAR2(255)  CONSTRAINT ad_ad_phone_uk UNIQUE,       -- ��� ����ó
     admin_email    VARCHAR2(255)  CONSTRAINT ad_ad_email_nn NOT NULL,     -- ��� �̸���
     admin_address  VARCHAR2(255)  CONSTRAINT ad_ad_address_nn NOT NULL,   -- ��� �ּ�
     admin_registrationdate  DATE  CONSTRAINT ad_ad_reg_date_nn NOT NULL,  -- ��� ����� 
     admin_note     VARCHAR2(255)                                          -- ���
);

-- ȸ�� ���� ���̺�
CREATE TABLE members (
     mem_num        NUMBER(11) CONSTRAINT m_m_num_pk  PRIMARY KEY,    -- ȸ�� ��ȣ  (PK)
     mem_name       VARCHAR2(255) CONSTRAINT m_m_name_nn NOT NULL,    -- ȸ�� �̸�
     mem_id         VARCHAR2(255) CONSTRAINT m_m_id_uk UNIQUE,        -- ȸ�� ���̵� (UK)
     mem_pw         VARCHAR2(255) CONSTRAINT m_m_pw_nn NOT NULL,      -- ȸ�� ��й�ȣ
     mem_birthday   CHAR(6) CONSTRAINT m_m_birthday_nn NOT NULL,      -- ȸ�� �������
     mem_sex        CHAR(1) CONSTRAINT m_m_sex_boolean CHECK(mem_sex IN ('0', '1')), -- ȸ�� ���� (0,1 �� ����)
     mem_phone      VARCHAR2(255) CONSTRAINT m_m_phone_uk UNIQUE,     -- ȸ�� ����ó (UK)
     mem_email      VARCHAR2(255) CONSTRAINT m_m_email_nn NOT NULL,   -- ȸ�� �̸���
     mem_address    VARCHAR2(255) CONSTRAINT m_m_address_nn NOT NULL, -- ȸ�� �ּ�
     mem_registrationdate DATE CONSTRAINT m_m_reg_date_nn NOT NULL,   -- ȸ�� ��� ��ȣ
     mem_note       VARCHAR2(255)                                     -- ���
);

-- ���� ���� ���̺�
CREATE TABLE books(
     book_id        VARCHAR2(255)  CONSTRAINT b_b_id_pk  PRIMARY KEY,      -- ���� ��Ϲ�ȣ (PK)
     book_title     VARCHAR2(255)  CONSTRAINT b_b_title_nn NOT NULL,       -- ���� ����
     book_author    VARCHAR2(255)  CONSTRAINT b_b_author_nn NOT NULL,      -- ���� ����
     book_publisher VARCHAR2(255)  CONSTRAINT b_b_publisher_nn NOT NULL,   -- ���� ���ǻ�
     book_isbn  VARCHAR2(255) CONSTRAINT b_b_isbn_uk UNIQUE,               -- ���� ISBN ��ȣ  (UK)
     book_bias      NUMBER(11) DEFAULT 1,                                  -- ���� ����� (�⺻�� 1)
     book_duplicates NUMBER(11) DEFAULT 1,                                 -- ���� ���Ǽ� (�⺻�� 1)
     book_registration_date   DATE CONSTRAINT b_b_reg_nn NOT NULL,         -- ���� �����
     book_price     NUMBER(11),                                            -- ���� ����
     location_id    CHAR(1) CONSTRAINT b_loc_id_fk REFERENCES locations(location_id), -- ���� ��ġ (FK)
     book_note      VARCHAR2(255)                                          -- ���
);

--CREATE TABLE callsign(
--     book_callsign  VARCHAR2(255)  CONSTRAINT c_b_cs_pk  PRIMARY KEY,
--     cs_classification_code VARCHAR2(255),
--     cs_sign           VARCHAR2(255),
--     cs_bias           NUMBER(11),
--     cs_duplicates     NUMBER(11)
--);

-- ���� �з� / ��ġ ���̺�
CREATE TABLE locations(
     location_id    CHAR(1) CONSTRAINT l_l_id_pk  PRIMARY KEY,        -- ���� ��ġ ���̵�   (PK)
     location_name  VARCHAR2(255) CONSTRAINT l_l_name_nn NOT NULL     -- ���� ��ġ �̸�
);

-- ���� ���� ���̺�
CREATE TABLE check_out_info(
     check_out_id   NUMBER(11) CONSTRAINT coi_coi_id_pk PRIMARY KEY,                 -- �뿩 ���̵� (PK)
     book_id        VARCHAR2(255) CONSTRAINT coi_b_id_fk REFERENCES books(book_id),  -- �뿩 ����   (FK)
     mem_num        NUMBER(11) CONSTRAINT coi_m_num_fk REFERENCES members(mem_num),  -- ȸ�� ��ȣ   (FK)
     check_out_date DATE CONSTRAINT coi_c_o_date_nn NOT NULL,                        -- �뿩 ��¥
     expect_return_date DATE,                                                        -- �ݳ� ���� ��¥
     check_in_date  DATE                                                             -- �ݳ� ��¥
);

-- ������ ���� ���̺�
CREATE TABLE readingroom(
     seat_num       NUMBER(11) CONSTRAINT r_s_num_pk PRIMARY KEY,     -- �¼� ��ȣ  (PK)
     table_divider  CHAR(1),                                          -- ĭ���� ����
     seat_sex       CHAR(1)                                           -- �¼� ����
);

-- �¼� �̿� ���� ���̺�
CREATE TABLE seat_use_details(
     use_id    NUMBER(11) CONSTRAINT sud_u_id_pk PRIMARY KEY,                        -- ������ ��볻�� ���̵�     (PK)
     mem_num   NUMBER(11) CONSTRAINT sud_m_num_fk REFERENCES members(mem_num),       -- ȸ������   (FK)
     seat_num  NUMBER(11) CONSTRAINT sud_s_num_fk REFERENCES readingroom(seat_num),  -- �¼� ��ȣ  (FK)
     start_time DATE CONSTRAINT sud_s_time_nn NOT NULL,                              -- ��� ���� �ð�
     end_time DATE                                                                   -- ��� ���� �ð�
);

-- �̹��� ���� ���̺�
CREATE TABLE IMAGE_INFORMATION(
     image_id  NUMBER(11) CONSTRAINT i_i_id_pk PRIMARY KEY,                          -- �̹��� ���̵�     (PK)
     image_name     VARCHAR2(255) CONSTRAINT i_i_name_nn NOT NULL,                   -- �̹��� �̸�
     image_byte_info      BLOB CONSTRAINT i_i_b_info_nn NOT NULL                     -- �̹��� byte ����
);

-- ȸ�� ��ȣ ������
CREATE SEQUENCE mem_num_seq
     INCREMENT BY 1
     START WITH 1
     MINVALUE 1
     MAXVALUE 99999999
     CYCLE
     NOCACHE;
     
-- ��� ��ȣ ������
CREATE SEQUENCE admin_num_seq
     INCREMENT BY 1
     START WITH 1
     MINVALUE 1
     MAXVALUE 99999999
     CYCLE
     NOCACHE;

-- ���� ��Ϲ�ȣ ������
CREATE SEQUENCE book_id_seq
     INCREMENT BY 1
     START WITH 1
     MINVALUE 1
     MAXVALUE 999999999
     CYCLE
     NOCACHE;

-- ������ ��� ���� ���̵� ������
CREATE SEQUENCE user_detail_id_seq
     INCREMENT BY 1
     START WITH 1
     MINVALUE 1
     MAXVALUE 99999999
     CYCLE
     NOCACHE;

-- �뿩 ���̵� ������
CREATE SEQUENCE check_out_id_seq
     INCREMENT BY 1
     START WITH 1
     MINVALUE 1
     MAXVALUE 99999999
     CYCLE
     NOCACHE;

SELECT * FROM tabs;
