package com.sv.ar.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.html2pdf.HtmlConverter;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

@RestController
public class GeneratePdf {

    //Method which accept the html string format and convert it into the pdf.
	@PostMapping(value = "/downloadPdf", produces = "application/MediaType.APPLICATION_PDF_VALUE")
	public void exportPdfUsingString(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String html) {

		try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			Document document = new Document(PageSize.ID_1);
			PdfWriter.getInstance(document, outputStream);
			HtmlConverter.convertToPdf(html, outputStream);
			ByteArrayInputStream is = new ByteArrayInputStream(outputStream.toByteArray());
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode("html-to-pdf.pdf", "utf-8"));
			System.out.println("PDF Created!");
			IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
