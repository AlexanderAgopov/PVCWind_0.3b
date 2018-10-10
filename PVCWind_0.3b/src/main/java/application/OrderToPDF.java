package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javafx.collections.ObservableList;

/**
 * The objects of class OrderToPDF extract data from the order currently loaded
 * in the application, create new pdf document and fill it with this data.
 * 
 * @author a
 *
 */
public class OrderToPDF {

	private PdfWriter writer;
	private PdfDocument pdf;
	private Document document;

	public OrderToPDF() {
		super();
		this.writer = writer;
		this.pdf = pdf;
		this.document = document;
	}

	public void createPDF(String fileName, ObservableList<String> list) {

		try {
			PdfFont f1 = PdfFontFactory.createFont("./resources/DejaVuSansCondensed.ttf", "Identity-H", true);
			PdfFont f2 = PdfFontFactory.createFont("./resources/DejaVuSansCondensed-Bold.ttf", "Identity-H", true);
			PdfFont f3 = PdfFontFactory.createFont("./resources/DejaVuSansCondensed-BoldOblique.ttf", "Identity-H",
					true);

			this.writer = new PdfWriter("./pdf_files/" + fileName);

			this.pdf = new PdfDocument(writer);
			this.document = new Document(pdf);

			document.add(new Paragraph("ЗАЯВКА: " + fileName).setFont(f2));

			for (String s : list) {
				document.add(new Paragraph(s).setFont(f1));
			}

			String glass = String.format(
					"Стъклопакет: Цена на м%c: %.2f лв., Количество: %.3f m%c, Обща цена: %.2f лв.", '\u00B2',
					application.Main.order.getPricePerSqMGlass(), application.Main.order.getTotalSqMGlass(), '\u00B2',
					application.Main.order.getTotalPriceGlass());

			document.add(new Paragraph(glass).setFont(f3));

			String frame = String.format("Профил: Цена на л.м: %.2f лв., Количество: %.2f л.м, Обща цена: %.2f лв.",
					application.Main.order.getPricePerLMFrame(), application.Main.order.getTotalLMFrame(),
					application.Main.order.getTotalPriceFrame());

			document.add(new Paragraph(frame).setFont(f3));
			document.add(
					new Paragraph(String.format("Крайна цена: %.2f лв.", application.Main.order.getTotalPriceOrder()))
							.setFont(f2));

			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
	}
}
