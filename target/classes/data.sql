SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE names;
SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE names ALTER COLUMN id RESTART WITH 1;