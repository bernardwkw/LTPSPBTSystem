package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "hua.tung.spbt.ltp.ltpspbtsystem.db"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addUserEntities(schema);
//         addPhonesEntities(schema);
    }

    // This is use to describe the colums of your table
    private static Entity addUserEntities(final Schema schema) {

        Entity log = schema.addEntity("LogRegisterQuery");
        log.addLongProperty(Consts.REGIS_ID).primaryKey();
        log.addStringProperty(Consts.DEVICE_ID);
        log.addStringProperty(Consts.OFFICE_ID);
        log.addStringProperty(Consts.LICENSEE);
        log.addStringProperty(Consts.PROPERTY_MARK);
        log.addStringProperty(Consts.PEC_REF_NO);
        log.addStringProperty(Consts.LPI_NO);
        log.addStringProperty(Consts.DPR_REF_NO);
        log.addStringProperty(Consts.RA_REF_NO);
        log.addStringProperty(Consts.HARVEST_DATE);
        log.addStringProperty(Consts.COUPE_NO);
        log.addStringProperty(Consts.BLOCK_NO);
        log.addStringProperty(Consts.CAMP_CODE);
        log.addStringProperty(Consts.LOG_SERIAL_NO);
        log.addStringProperty(Consts.SPECIES_CODE);
        log.addDoubleProperty(Consts.LENGTH);
        log.addDoubleProperty(Consts.DIAMETER);
        log.addDoubleProperty(Consts.DEFECT_DIA);
        log.addDoubleProperty(Consts.NET_VOL);
        log.addDoubleProperty(Consts.COMPUTE_VOL);
        log.addStringProperty(Consts.RA_PROCESSING_OFFICE);
        log.addStringProperty(Consts.HAMMER_MARK_NO);
        log.addStringProperty(Consts.PLACE_RA_MARKING);
        log.addStringProperty(Consts.TRP_REF_NO);
        log.addStringProperty(Consts.NAME);
        log.addStringProperty(Consts.TRAN_MODE);
        log.addStringProperty(Consts.BY_NAME);
        log.addStringProperty(Consts.RP_NO);
        log.addStringProperty(Consts.TO_LOC);
        log.addStringProperty(Consts.FRM_LOC);
        log.addStringProperty(Consts.SYNC_STATUS);

        Entity doc = schema.addEntity("MobileDoc");
//        doc.addIdProperty().primaryKey().autoincrement();
        doc.addStringProperty(Consts.EXCH_ID).primaryKey();
        doc.addStringProperty(Consts.OFFICE_ID);
        doc.addStringProperty(Consts.DEVICE_ID);
        doc.addStringProperty(Consts.DOC_TYPE);
        doc.addStringProperty(Consts.SOURCE_DOC_ID);
        doc.addStringProperty(Consts.NAME);
        doc.addIntProperty(Consts.TOTAL_LOGS);
        doc.addStringProperty(Consts.BATCH_NO);
        doc.addStringProperty(Consts.LICENSE_TYPE);
        doc.addStringProperty(Consts.ACCT_CODE);
        doc.addStringProperty(Consts.HAMMER_MARK_NO);
        doc.addStringProperty(Consts.FOREST_TYPE);
        doc.addStringProperty(Consts.TYPE_OF_PRODUCE);
        doc.addStringProperty(Consts.TRP_REF_NO);
        doc.addStringProperty(Consts.SECURITY_NO);
        doc.addStringProperty(Consts.TRAN_MODE);
        doc.addStringProperty(Consts.BY_NAME );
        doc.addStringProperty(Consts.RP_NO );
        doc.addStringProperty(Consts.RP_BOOK_NO );
        doc.addStringProperty(Consts.BARGE_RAFT );
        doc.addStringProperty(Consts.FRM_LOC);
        doc.addStringProperty(Consts.TO_LOC);
        doc.addStringProperty(Consts.RECEIVING_OFFICE);
        doc.addStringProperty(Consts.ISSUEING_OFFICE);
        doc.addStringProperty(Consts.TRP_DATE_ISSUED);
        doc.addStringProperty(Consts.TRP_DATE_EXPIRE);
        doc.addStringProperty(Consts.TRP_ISSUED_BY);
        doc.addStringProperty(Consts.ECC_EXCC_NO);
        doc.addStringProperty(Consts.ECC_EXCC_ISSUE_DATE);
        doc.addStringProperty(Consts.SH_REF_NO);
        doc.addStringProperty(Consts.SH_REASON);
        doc.addStringProperty(Consts.EXCH_STATUS);
        doc.addStringProperty(Consts.SYNC_STATUS);
        doc.addStringProperty(Consts.SYNC_DATE);
        doc.addStringProperty(Consts.CREATED_BY);
        doc.addStringProperty(Consts.CREATED_DATE);
        doc.addStringProperty(Consts.MODIFIED_BY);
        doc.addStringProperty(Consts.MODIFIED_DATE);
        doc.addStringProperty(Consts.MODIFIED_SRC);

        Entity device = schema.addEntity("DeviceSetup");
        device.addStringProperty(Consts.DEVICE_ID).primaryKey();
        device.addStringProperty(Consts.DEVICE_NAME);
        device.addStringProperty(Consts.DEVICE_MODEL);
        device.addStringProperty(Consts.DEVICE_SERIAL_NO);
        device.addStringProperty(Consts.MOBILE_ID);
        device.addStringProperty(Consts.CREATED_BY);
        device.addStringProperty(Consts.CREATED_DATE);
        device.addStringProperty(Consts.MODIFIED_BY);
        device.addStringProperty(Consts.MODIFIED_DATE);
        device.addStringProperty(Consts.MODIFIED_SRC);

        Entity user = schema.addEntity("User");
        user.addStringProperty(Consts.SECURITY_USER_LOGIN_ID).primaryKey();
        user.addStringProperty(Consts.SECURITY_USER_NAME);
        user.addStringProperty(Consts.SECURITY_USER_STATUS);
        user.addStringProperty(Consts.SECURITY_USER_PASSWORD);
        user.addStringProperty(Consts.MODIFIED_BY);
        user.addStringProperty(Consts.MODIFIED_DATE);
        user.addStringProperty(Consts.MODIFIED_SRC);

        Entity logRegister = schema.addEntity("LogRegister");
        logRegister.addStringProperty(Consts.EXCH_DET_ID).primaryKey();
        logRegister.addStringProperty(Consts.EXCH_ID);
        logRegister.addStringProperty(Consts.REGIS_ID);
        logRegister.addStringProperty(Consts.COUPE_NO);
        logRegister.addStringProperty(Consts.BLOCK_NO);
        logRegister.addStringProperty(Consts.CAMP_CODE);
        logRegister.addStringProperty(Consts.LPI_NO);
        logRegister.addStringProperty(Consts.LOG_SERIAL_NO);
        logRegister.addStringProperty(Consts.SPECIES_CODE);
        logRegister.addStringProperty(Consts.PRO_MARK_REG_NO);
        logRegister.addDoubleProperty(Consts.LENGTH);
        logRegister.addDoubleProperty(Consts.DIAMETER);
        logRegister.addDoubleProperty(Consts.DEFECT_DIA);
        logRegister.addDoubleProperty(Consts.NET_VOL);
        logRegister.addDoubleProperty(Consts.COMPUTE_VOL);
        logRegister.addStringProperty(Consts.SPEC_CHECK);

        Entity inspect = schema.addEntity("InspectUpload");
        inspect.addStringProperty(Consts.INSPECT_ID).primaryKey();
        inspect.addStringProperty(Consts.REGIS_ID);
        inspect.addStringProperty(Consts.EXCH_DET_ID);
        inspect.addStringProperty(Consts.USER_LOGIN_ID);
        inspect.addStringProperty(Consts.USER_NAME);
        inspect.addStringProperty(Consts.COLOR_TAG_NO);
        inspect.addStringProperty(Consts.INSPECT_DATE_TIME);
        inspect.addDoubleProperty(Consts.GPS_LAT);
        inspect.addDoubleProperty(Consts.GPS_LONG);
        inspect.addStringProperty(Consts.LPI_CHK);
        inspect.addStringProperty(Consts.LPI_CHK_RESULT);
        inspect.addStringProperty(Consts.SPECIES_CHK);
        inspect.addStringProperty(Consts.SPECIES_CHK_RESULT);
        inspect.addStringProperty(Consts.PRO_MARK_CHK);
        inspect.addStringProperty(Consts.PRO_MARK_CHK_RESULT);
        inspect.addStringProperty(Consts.JH_HAMMER_CHK);
        inspect.addStringProperty(Consts.JH_HAMMER_CHK_RESULT);
        inspect.addStringProperty(Consts.DIAMETER_CHK);
        inspect.addStringProperty(Consts.DIA_CHK_RESULT);
        inspect.addStringProperty(Consts.LENGTH_CHK);
        inspect.addStringProperty(Consts.LENGTH_CHK_RESULT);
        inspect.addStringProperty(Consts.REMARKS);

        Entity myInspect = schema.addEntity("MyInspectUpload");
        myInspect.addLongProperty(Consts.INSPECT_ID).primaryKey().autoincrement();
        myInspect.addStringProperty(Consts.REGIS_ID);
        myInspect.addStringProperty(Consts.EXCH_DET_ID);
        myInspect.addStringProperty(Consts.USER_LOGIN_ID);
        myInspect.addStringProperty(Consts.USER_NAME);
        myInspect.addStringProperty(Consts.COLOR_TAG_NO);
        myInspect.addStringProperty(Consts.INSPECT_DATE_TIME);
        myInspect.addDoubleProperty(Consts.GPS_LAT);
        myInspect.addDoubleProperty(Consts.GPS_LONG);
        myInspect.addStringProperty(Consts.LPI_CHK);
        myInspect.addStringProperty(Consts.LPI_CHK_RESULT);
        myInspect.addStringProperty(Consts.SPECIES_CHK);
        myInspect.addStringProperty(Consts.SPECIES_CHK_RESULT);
        myInspect.addStringProperty(Consts.PRO_MARK_CHK);
        myInspect.addStringProperty(Consts.PRO_MARK_CHK_RESULT);
        myInspect.addStringProperty(Consts.JH_HAMMER_CHK);
        myInspect.addStringProperty(Consts.JH_HAMMER_CHK_RESULT);
        myInspect.addStringProperty(Consts.DIAMETER_CHK);
        myInspect.addStringProperty(Consts.DIA_CHK_RESULT);
        myInspect.addStringProperty(Consts.LENGTH_CHK);
        myInspect.addStringProperty(Consts.LENGTH_CHK_RESULT);
        myInspect.addStringProperty(Consts.REMARKS);


//        Entity timberVerification = schema.addEntity("TimberVerification");
//        timberVerification.addIdProperty().primaryKey().autoincrement();
//        timberVerification.addStringProperty("barcode");
//        timberVerification.addStringProperty("longitude");
//        timberVerification.addStringProperty("latitude");
//        timberVerification.addDateProperty("created_at");
//
//        Entity timberInfo = schema.addEntity("TimberInfo");
//        timberInfo.addIdProperty().primaryKey().autoincrement();
//        timberInfo.addStringProperty("timber_id");
//        timberInfo.addFloatProperty("timber_diameter");
//        timberInfo.addFloatProperty("timber_length");
//        timberInfo.addStringProperty("timber_species");
//        timberInfo.addStringProperty("timber_origin");
//        timberInfo.addStringProperty("timber_destination");
//        timberInfo.addDateProperty("timber_sawn_at");
//
//        Property userIdProperty = timberVerification.addLongProperty("userId").getProperty();
//        timberVerification.addToOne(log, userIdProperty);
//
//        Property timberIdProperty = timberVerification.addLongProperty("timberId").getProperty();
//        timberVerification.addToOne(timberInfo, timberIdProperty);

        return log;
    }
}
