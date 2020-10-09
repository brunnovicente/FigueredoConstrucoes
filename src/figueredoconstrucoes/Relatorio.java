/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figueredoconstrucoes;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entidades.Produto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunn
 */
public class Relatorio {
    
    public File gerarRelatorioProdutos(List<Produto> lista, boolean tipo) throws DocumentException, FileNotFoundException, BadElementException, MalformedURLException, IOException, SQLException{
        String caminho = "relatorioprodutos.pdf";
        //double total_vendas = 0;
        Document documento = null;
        OutputStream saida = null;
               
        documento = new Document(PageSize.A4, 20, 20, 20, 20);
        saida = new FileOutputStream(caminho);
        PdfWriter.getInstance(documento, saida);
        
        documento.open();

        //CRIANDO O TITULO DA FICHA E DO LOGOTIPO
        Font fonte = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
        
        String rel = "Relatório de Produtos";
        if(tipo){
            rel = "Relatório de Produtos em Falta";
        }
               
        Paragraph titulo = new Paragraph("Figueredo Construções"+ "\n"+rel+"\n", fonte);
        titulo.setAlignment(Element.ALIGN_CENTER);

        //Pegando o logotipo do jevania
        Image logo = Image.getInstance("logo.png");
        logo.setAlignment(Element.ALIGN_CENTER);
        
        PdfPTable tabela_titulos = new PdfPTable(new float[]{0.10f, 0.90f});
        //tabela_titulos.setWidthPercentage(100.0f);
        PdfPCell celula1 = new PdfPCell();
        celula1.setBorderColor(BaseColor.WHITE);
        celula1.setImage(logo);
        celula1.setFixedHeight(20);
        
        PdfPCell celula2 = new PdfPCell(titulo);
        celula2.setBorderColor(BaseColor.WHITE);
        tabela_titulos.addCell(celula1);
        tabela_titulos.addCell(celula2);
        tabela_titulos.setHorizontalAlignment(Element.ALIGN_LEFT);
        
              
        
        //Criação da Tabela de Itens
        fonte = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        PdfPTable tabela_itens = new PdfPTable(new float[]{0.15f, 0.30f, 0.10f, 0.10f, 0.20f});
        tabela_itens.setWidthPercentage(100.0f);
        tabela_itens.setSpacingBefore(8); 

        Paragraph lcodigo = new Paragraph("CÓDIGO", fonte);
        Paragraph ldescricao = new Paragraph("DESCRIÇÃO", fonte);
        Paragraph lquantidade = new Paragraph("QTD", fonte);
        Paragraph lminimo = new Paragraph("MÍNIMO", fonte);
        Paragraph lpreco = new Paragraph("PREÇO", fonte);

        PdfPCell cel_codigo = new PdfPCell(lcodigo);
        cel_codigo.setHorizontalAlignment(Element.ALIGN_CENTER);
        cel_codigo.setBorderColor(BaseColor.BLACK);
        //cel_codigo.setBorderWidthTop(0);
        cel_codigo.setBorderWidthLeft(0);
        cel_codigo.setBorderWidthRight(0);

        PdfPCell cel_descricao = new PdfPCell(ldescricao);
        cel_descricao.setHorizontalAlignment(Element.ALIGN_LEFT);
        cel_descricao.setBorderColor(BaseColor.BLACK);
        //cel_descricao.setBorderWidthTop(0);
        cel_descricao.setBorderWidthLeft(0);
        cel_descricao.setBorderWidthRight(0);

        PdfPCell cel_quantidade = new PdfPCell(lquantidade);
        cel_quantidade.setHorizontalAlignment(Element.ALIGN_CENTER);
        cel_quantidade.setBorderColor(BaseColor.BLACK);
        //cel_quantidade.setBorderWidthTop(0);
        cel_quantidade.setBorderWidthLeft(0);
        cel_quantidade.setBorderWidthRight(0);

        PdfPCell cel_minimo = new PdfPCell(lminimo);
        cel_minimo.setHorizontalAlignment(Element.ALIGN_CENTER);
        cel_minimo.setBorderColor(BaseColor.BLACK);
        //cel_quantidade.setBorderWidthTop(0);
        cel_minimo.setBorderWidthLeft(0);
        cel_minimo.setBorderWidthRight(0);
        
        PdfPCell cel_preco = new PdfPCell(lpreco);
        cel_preco.setHorizontalAlignment(Element.ALIGN_CENTER);
        cel_preco.setBorderColor(BaseColor.BLACK);
        //cel_preco.setBorderWidthTop(0);
        cel_preco.setBorderWidthLeft(0);
        cel_preco.setBorderWidthRight(0);

        tabela_itens.addCell(cel_codigo);
        tabela_itens.addCell(cel_descricao);
        tabela_itens.addCell(cel_quantidade);
        tabela_itens.addCell(cel_minimo);
        tabela_itens.addCell(cel_preco);

        
        PdfPTable tabela_lista_itens = new PdfPTable(new float[]{0.15f, 0.30f, 0.10f, 0.10f, 0.20f});
        tabela_lista_itens.setWidthPercentage(100.0f);
        tabela_lista_itens.setSpacingBefore(5); 

        fonte = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
        
        for(Produto p : lista){
            System.out.println("GERANDO... "+p.getDescricao());
            
            //Adicionando os itens na tabela

            Paragraph codigo = new Paragraph(p.getCodigoBarra()+"",fonte);
            Paragraph descricao = new Paragraph(p.getDescricao()+"",fonte);
            Paragraph quantidade = new Paragraph(p.getEstoque()+"",fonte);
            Paragraph minimo = new Paragraph(p.getMinimo()+"",fonte);
            Paragraph preco = new Paragraph(("R$ "+p.getPreco()+"").replace(".", ","),fonte);


            PdfPCell cel_cod = new PdfPCell(codigo);
            cel_cod.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel_cod.setBorderColor(BaseColor.WHITE);

            PdfPCell cel_desc = new PdfPCell(descricao);
            cel_desc.setHorizontalAlignment(Element.ALIGN_LEFT);
            cel_desc.setBorderColor(BaseColor.WHITE);

            PdfPCell cel_qtd = new PdfPCell(quantidade);
            cel_qtd.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel_qtd.setBorderColor(BaseColor.WHITE);

            PdfPCell cel_min = new PdfPCell(minimo);
            cel_min.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel_min.setBorderColor(BaseColor.WHITE);

            PdfPCell cel_pre = new PdfPCell(preco);
            cel_pre.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel_pre.setBorderColor(BaseColor.WHITE);


            tabela_lista_itens.addCell(cel_cod);
            tabela_lista_itens.addCell(cel_desc);
            tabela_lista_itens.addCell(cel_qtd);
            tabela_lista_itens.addCell(cel_min);
            tabela_lista_itens.addCell(cel_pre);
        }
        documento.add(tabela_titulos);
        documento.add(tabela_itens);
        documento.add(tabela_lista_itens);
        
        File file = new File(caminho);
        documento.close();
        saida.close();
        
        return file;

    }//Fim da geração de relatorio de vendas
    
}
