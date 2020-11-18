package com.leet.ds.misc;


import com.leet.daysofcode.may.week2.Trie;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        String path = "/Users/utkarshsrivastava/git/erudite-spot/erudite-webapp/src/main/resources/FinalWordList.xls";

        Trie trie = new Trie();

        try(Workbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)))){
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()){
                String word = new DataFormatter().formatCellValue(rowIterator.next().getCell(1)).trim().toLowerCase();
                trie.insert(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(trie.getWordsWithPrefix("ab"));
    }

}

