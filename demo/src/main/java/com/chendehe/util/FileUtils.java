package com.chendehe.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

public final class FileUtils {

  private FileUtils() {
  }

  public static List<Workbook> decompressZip(MultipartFile file) {

    try (InputStream is = file.getInputStream();
         ZipInputStream zis = new ZipInputStream(is)) {
      List<byte[]> byteList = new ArrayList<>();
      ZipEntry zipEntry;
      while (null != (zipEntry = zis.getNextEntry())) {
        if (!zipEntry.isDirectory()) {
          byteList.add(getBytes(zis));
        }
      }
      List<Workbook> wbList = new CopyOnWriteArrayList<>();
      byteList.parallelStream().forEach(bytes -> {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
          Workbook e = WorkbookFactory.create(bais);
          wbList.add(e);
        } catch (IOException | InvalidFormatException e) {
          throw new RuntimeException("decompressBytes error", e);
        }
      });
      return wbList;
    } catch (IOException e) {
      throw new RuntimeException("decompressZip error", e);
    }
  }

  private static byte[] getBytes(InputStream is) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

      // validate zip
      byte[] head = new byte[4];
      int length;
      if ((length = is.read(head)) != -1) {
        baos.write(head, 0, length);
        int headHex = 0;
        for (byte b : head) {
          headHex <<= 8;
          headHex |= b;
        }
        if (headHex != 0x504B0304) {
          throw new RuntimeException("not zip type");
        }
      }

      //to byte[]
      byte[] temp = new byte[1024];
      while ((length = is.read(temp)) != -1) {
        baos.write(temp, 0, length);
      }
      return baos.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException("is to byte error", e);
    }
  }

  public static String mapToHtml(Map<String, Object> map) {
    return readFileByLine(FreeMarkerUtils.fprint(map));
  }

  private static String readFileByLine(byte[] bytes) {
    try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
         InputStreamReader isr = new InputStreamReader(bais);
         BufferedReader br = new BufferedReader(isr)) {

      StringBuilder builder = new StringBuilder();
      String tempString;
      while ((tempString = br.readLine()) != null) {
        builder.append(tempString);
      }
      return builder.toString();

    } catch (IOException e) {
      throw new RuntimeException("readFileByLine error", e);
    }
  }

}
