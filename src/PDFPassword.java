import java.io.File;
import java.io.IOException;

import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.ReaderProperties;
import com.itextpdf.kernel.pdf.WriterProperties;


public class PDFPassword {

	public static final String SRC = "compressed.tracemonkey-pldi-09.pdf";
	public static final String DEST = "hello_encrypted.pdf";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File(DEST);
			// file.getParentFile().mkdirs();
			new PDFPassword().manipulatePdf(DEST);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void manipulatePdf(String src) throws IOException {
		PdfReader reader = new PdfReader(SRC, new ReaderProperties().setPassword("World".getBytes()));
		PdfWriter writer = new PdfWriter(DEST,
		new WriterProperties().setStandardEncryption("Hello".getBytes(), "World".getBytes(),
						EncryptionConstants.ALLOW_PRINTING,
						EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA));
		PdfDocument pdfDoc = new PdfDocument(reader, writer);
		pdfDoc.close();
	}
}
