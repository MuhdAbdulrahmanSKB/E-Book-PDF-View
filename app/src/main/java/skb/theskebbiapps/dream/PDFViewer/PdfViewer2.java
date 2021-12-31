package skb.theskebbiapps.dream.PDFViewer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import skb.theskebbiapps.dream.R;

public class PdfViewer2 extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        pdfView=findViewById(R.id.pdfView);

        int story_position=getIntent().getIntExtra("key_position",0);

        if (story_position==0){
            pdfView.fromAsset("story1.pdf").load();
        }

        else if (story_position==1){
            pdfView.fromAsset("story2.pdf").load();
        }

        else if (story_position==2){
            pdfView.fromAsset("story3.pdf").load();
        }
    }
}