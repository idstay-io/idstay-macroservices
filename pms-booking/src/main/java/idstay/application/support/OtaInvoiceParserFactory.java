package idstay.application.support;

public class OtaInvoiceParserFactory {
    private static final String EXPEDIA_CHECKER = "Expedia";

    public OtaInvoiceParser getParser(final String otaInvoice) {
        if (otaInvoice.contains(EXPEDIA_CHECKER)) {
            return new ExpediaInvoiceParser(otaInvoice);
        } else {
            return null;
        }
    }
}