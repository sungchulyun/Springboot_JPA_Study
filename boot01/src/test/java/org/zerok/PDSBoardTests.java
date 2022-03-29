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

import java.util.Arrays;

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
}
