import java.io.File;
import java.io.FileOutputStream;
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
		
		try {
		//	File file = new File(DEST);
			// file.getParentFile().mkdirs();
			new PDFPassword().manipulatePdf(SRC,DEST);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void manipulatePdf(String src,String dest) throws IOException {
		File source = new File(src);
		

		PdfReader reader = new PdfReader(SRC, new ReaderProperties().setPassword("World".getBytes()));
		PdfWriter writer = new PdfWriter(DEST,
		new WriterProperties().setStandardEncryption("Hello".getBytes(), "World".getBytes(),
						EncryptionConstants.ALLOW_PRINTING,
						EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA));
		PdfDocument pdfDoc = new PdfDocument(reader, writer);
		File destination = new File(dest);
		source.delete();
		destination.renameTo(new File(src));
		
		pdfDoc.close();
	}
}


