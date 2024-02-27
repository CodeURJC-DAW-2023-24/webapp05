package es.codeurjc.Instapick.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import com.itextpdf.kernel.pdf.PdfDocument;
// import com.itextpdf.kernel.pdf.PdfWriter;
// import com.itextpdf.layout.Document;
// import com.itextpdf.layout.element.Paragraph;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getMethodName(Model model, Principal principal) {
        UserService users =new UserService();
        User user = users.findByUserName(principal.getName())
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        model.addAttribute("username",user.getUserName());
        model.addAttribute("name",user.getName());
        model.addAttribute("email", user.getEmail());
        return "profile";
    }
    
    // @RequestMapping("/profile/pdf")
    // public ResponseEntity<byte[]> createPDF(@PathVariable String name){
    //     String outputFilePath = "document.pdf";
    //     UserService users = new UserService();
    //     User user = users.findByUserName(name);
        
    //     try{
    //         //Crear un nuevo documento PDF
    //         PdfWriter writer = new PdfWriter(outputFilePath);
    //         PdfDocument pdfDoc = new PdfDocument(writer);
    //         Document doc = new Document(pdfDoc);
    //         //Agregar el texto
    //         Paragraph para = new Paragraph("Cuenta de usuario"+user.getUserName());
    //         doc.add(para);
    //         para = new Paragraph("Nombre de usuario"+user.getName());
    //         doc.add(para);
    //         para = new Paragraph("Email"+user.getEmail());
    //         doc.add(para);
    //         //Guardar el documento
    //         doc.close();
    //         /* Setup Source and target I/O streams */
    //         //ByteArrayInputStream source = new ByteArrayInputStream();
    //         FileInputStream source = new FileInputStream(outputFilePath);
    //         //ByteArrayOutputStream target = new ByteArrayOutputStream();
    //         /* Call convert method */
    //         //HtmlConverter.convertToPdf(orderHtml, target, converterProperties);  
    //         /* extract output as bytes */
    //         byte[] bytes = null;
    //         try {
    //             bytes = source.readAllBytes();
    //         } catch (IOException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
    //         try {
    //             source.close();
    //         } catch (IOException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
    //         //byte[] bytes = target.toByteArray();
    //         /* Send the response as downloadable PDF */
    //         return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf") .contentType(MediaType.APPLICATION_PDF) .body(bytes);

    //     } catch(FileNotFoundException e){
    //         e.printStackTrace();
    //         //https://springhow.com/spring-boot-pdf-generation/
    //     }
    //     return null;
        
    // }
}
