package com.pokedex.lite.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pokedex.lite.models.entity.Ability;
import com.pokedex.lite.models.entity.Evolution;
import com.pokedex.lite.models.entity.Pokemon;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/pokemon/pokeList")
public class PokemonListPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Pokemon> listedPokemon = (List<Pokemon>) model.get("pokemons");
		
		//Font
		Font titleFont = FontFactory.getFont("Ubuntu",20,new  Color(19, 87, 54));
		Font columnTitleFont = FontFactory.getFont("Ubuntu",12,Color.WHITE);
		Font attributeFont = FontFactory.getFont("Ubuntu",11,Color.BLACK);
		
		//Page
		document.setPageSize(PageSize.A4);
		document.setMargins(-40, -40, 40, 20);
		document.open();
		PdfPCell cell = null;
		
		//Title
		PdfPTable titleTable = new PdfPTable(1);
		
					
		cell =  new PdfPCell(new Phrase("Pokémon List", titleFont));
		cell.setBorder(0);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setPadding(15);
		
		titleTable.addCell(cell);
		titleTable.setSpacingAfter(15);
		
		//List Table
		PdfPTable listTable = new PdfPTable(6);
		
		//Column Titles		
		cell = new PdfPCell(new Phrase("Name", columnTitleFont));
		cell.setBackgroundColor(new  Color(19, 87, 54));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5);
		listTable.addCell(cell);

		cell = new PdfPCell(new Phrase("Type", columnTitleFont));
		cell.setBackgroundColor(new  Color(19, 87, 54));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5);
		listTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Second Type", columnTitleFont));
		cell.setBackgroundColor(new  Color(19, 87, 54));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5);
		listTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Found Level", columnTitleFont));
		cell.setBackgroundColor(new  Color(19, 87, 54));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5);
		listTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Abilities", columnTitleFont));
		cell.setBackgroundColor(new  Color(19, 87, 54));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5);
		listTable.addCell(cell);		
		
		cell = new PdfPCell(new Phrase("Evolutions", columnTitleFont));
		cell.setBackgroundColor(new  Color(19, 87, 54));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5);
		listTable.addCell(cell);	

		//Pokémon attribute loop
		
		for(Pokemon pokemon : listedPokemon) {
			cell = new PdfPCell(new Phrase(pokemon.getName(), attributeFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(5);
			listTable.addCell(cell);
			
			cell = new PdfPCell(new Phrase(pokemon.getType(), attributeFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(5);
			listTable.addCell(cell);
			
			cell = new PdfPCell(new Phrase(pokemon.getExtraType(), attributeFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(5);
			listTable.addCell(cell);
			
			Integer level = pokemon.getFoundLevel();
			cell = new PdfPCell(new Phrase(level.toString(), attributeFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(5);
			listTable.addCell(cell);
			
			String abilityName = " ";
			for(Ability ability : pokemon.getAbilities()) {
				abilityName = abilityName + " - " + ability.getName() + "\n";
			}			
			cell = new PdfPCell(new Phrase(abilityName, attributeFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(5);
			listTable.addCell(cell);
			
			List<Evolution> evolutions = pokemon.getEvolutions();
			evolutions = evolutions.stream().filter(evolution -> Boolean.TRUE.equals(evolution.isEnabled()))
					.collect(Collectors.toList());
			String evolutionName = " ";
			for(Evolution evolution : evolutions) {
				evolutionName = evolutionName + " - " + evolution.getName() + "\n";
			}			
			cell = new PdfPCell(new Phrase(evolutionName, attributeFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(5);
			listTable.addCell(cell);
			
		}		
		
		document.add(titleTable);
		document.add(listTable);	
	}

}
