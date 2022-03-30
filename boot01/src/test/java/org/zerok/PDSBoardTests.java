package org.zerok;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerok.domain.PDSBoard;
import org.zerok.domain.PDSFile;
import org.zerok.persistence.PDSBoardRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log
@Commit
public class PDSBoardTests {

    @Autowired
    PDSBoardRepository repo;

    @Test
    public void testInsertPDS(){

        PDSBoard pds = new PDSBoard();
        pds.setPname("Document");

        PDSFile file1 = new PDSFile();
        file1.setPdsfile("file1.doc");

        PDSFile file2 = new PDSFile();
        file2.setPdsfile("file2.doc");

        pds.setFiles(Arrays.asList(file1, file2));

        repo.save(pds);
    }

    @Transactional
        @Test
            public void testUpdateFileName1(){

                Long fno = 1L;
                String newName = "updatedFile1.doc";

                int count = repo.updatePDSFile( fno, newName);


            }

    @Transactional
      @Test
        public void testUpdateFileName2(){

        String newName = "updatedFile2.doc";

        Optional<PDSBoard> result = repo.findById(2L);

        result.ifPresent(pds -> {
            PDSFile target = new PDSFile();
            target.setFno(2L);
            target.setPdsfile(newName);

            int idx = pds.getFiles().indexOf(target);

            if(idx > -1){

                List<PDSFile> list = pds.getFiles();
                list.remove(idx);
                list.add(target);
                pds.setFiles(list);
            }

            repo.save(pds);
        });
    }

    @Transactional
    @Test
    public void deletePDSFile(){

        Long fno = 2L;

        repo.deletePDSFile(fno);

    }

    @Test
    public void insertDummies() {
        List<PDSBoard> list = new ArrayList<>();

        IntStream.range(1,100).forEach(i -> {

            PDSBoard pds = new PDSBoard();
            pds.setPname("자료 " + i);

            PDSFile file1 = new PDSFile();
            file1.setPdsfile("file1.doc");

            PDSFile file2 = new PDSFile();
            file2.setPdsfile("file2.doc");

            pds.setFiles(Arrays.asList(file1, file2));

            list.add(pds);
        });

        repo.saveAll(list);
    }
}

