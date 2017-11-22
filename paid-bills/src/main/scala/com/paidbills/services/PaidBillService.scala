package com.paidbills.services

import java.io.{File, FileOutputStream, IOException, InputStream}
import java.time.{LocalDate, ZoneId}
import java.util.Date

import com.paidbills.dtos.{BillDto, UploadBillResponse}
import com.paidbills.repositories.PaidBillRepository
import org.glassfish.jersey.media.multipart.FormDataContentDisposition
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PaidBillService(@Autowired val paidBillRepo: PaidBillRepository) {

  def getDeatils(lastOneMonth: Boolean) = {
    if (lastOneMonth) {
      val date1 = LocalDate.now().minusMonths(1L);
      paidBillRepo.findByBillDateGreaterThan(Date.from(
        date1.atStartOfDay(
          ZoneId.of("America/Montreal")
        ).toInstant()
      ));
    } else {
      paidBillRepo.findAll();
    }
  }

  def save(billDto: BillDto) = paidBillRepo.save(billDto);

  def upload(uploadedInputStream: InputStream, fileDetail: FormDataContentDisposition) = {
    val uploadedFileLocation = "/home/cts1/projects/personal/HomeDashboard/paid-bills/src/main/resources/" + fileDetail.getFileName
    writeToFile(uploadedInputStream, uploadedFileLocation)
    val output = new UploadBillResponse("File uploaded to : " + uploadedFileLocation)
    output
  }

  private def writeToFile(uploadedInputStream: InputStream, uploadedFileLocation: String) {
    try {
      val out = new FileOutputStream(new File(uploadedFileLocation));
      var read = 0;
      while ( {read = uploadedInputStream.read(); read != -1} ) {
        out.write(read);
      }
      out.flush();
      out.close();
    } catch {
      case e: IOException => {
        e.printStackTrace();
      }
    }
  }

}
