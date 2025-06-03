package org.owasp.webgoat.lessons.vulnerablecomponents;

import java.io.File;
import java.io.IOException;
import org.hsqldb.lib.FileUtil;
import org.jsoup.helper.DataUtil;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DSAST {
  @PostMapping("/DAST/Spring/delete")
  public void springDelete(@RequestParam String input) {

    String directory = "./target/directory";
    String[] filenames = StringUtils.commaDelimitedListToStringArray(input);
    for (String filename : filenames) {
      var file = new File(directory, filename);
      FileSystemUtils.deleteRecursively(file);
    }
  }

  @PostMapping("/DAST/hsqldb/delete")
  public void hsqldbDelete(@RequestParam String filename) {

    String directory = "./target/directory";
    var file = new File(directory, filename);
    FileUtil.getFileUtil().delete(filename);
  }

  public void jsoupLoad(@RequestParam String filename) throws IOException {

    String directory = "./target/directory";
    var file = new File(directory, filename);
    DataUtil.load(file, "utf-8", "uri://");
  }
}
