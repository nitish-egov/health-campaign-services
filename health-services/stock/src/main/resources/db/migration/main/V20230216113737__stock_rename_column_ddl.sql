ALTER TABLE STOCK_RECONCILIATION_LOG
RENAME COLUMN additionalFields TO additionalDetails;


ALTER TABLE STOCK_RECONCILIATION_LOG ADD COLUMN productVariantId character varying(64);
ALTER TABLE STOCK_RECONCILIATION_LOG ADD COLUMN referenceId character varying(200);
ALTER TABLE STOCK_RECONCILIATION_LOG ADD COLUMN referenceIdType character varying(100);