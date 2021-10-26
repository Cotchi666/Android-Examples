package com.example.quanlinhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import entity.Employee;

public class ParseXMLActivity extends AppCompatActivity {

    ListView listView;
    Button button_DOM, button_SAX;
    Spinner spinner;
    List<Employee> list_listView;
    List<String> listSpinner, list;
    ArrayAdapter arrayAdapterSPin, arrayAdapter_lisView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_xmlactivity);
        anhxa();
        khoiTaoDS();
        button_DOM.setOnClickListener(view -> {
            readFileDOM("employee.html");
            arrayAdapterSPin.notifyDataSetChanged();
            arrayAdapter_lisView.notifyDataSetChanged();
        });
        button_SAX.setOnClickListener(view -> {
            readFileSAX("employee.html");
            arrayAdapterSPin.notifyDataSetChanged();
            arrayAdapter_lisView.notifyDataSetChanged();
        });
        arrayAdapter_lisView = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        arrayAdapterSPin = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listSpinner);
        spinner.setAdapter(arrayAdapterSPin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lisViewAdd(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void anhxa() {
        button_SAX = findViewById(R.id.button_SAX);
        listView = findViewById(R.id.employee_listView);
        button_DOM = findViewById(R.id.button_DOM);
        spinner = findViewById(R.id.spinner_title);
    }

    private void khoiTaoDS() {
        listSpinner = new ArrayList<>();
        list = new ArrayList<>();
        list_listView = new ArrayList<>();
    }

    private void lisViewAdd(int i) {
        list.clear();
        for (Employee e :
                list_listView) {
            if (e.getTitle().equals(listSpinner.get(i))) {
                list.add(e.getContent());
            }
        }
        listView.setAdapter(arrayAdapter_lisView);
    }


    private void readFileDOM(String strCacheFileName) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        File pathCacheDir = getCacheDir();

        File newCacheFile = new
                File(pathCacheDir, strCacheFileName);
        try {
            Document document = documentBuilder.parse(newCacheFile);

            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Element employee = (Element) node;
                    String id = employee.getAttribute("id");
                    String tittle = employee.getAttribute("title");
                    NodeList listchild = employee.getElementsByTagName("name");
                    String name = listchild.item(0).getTextContent();
                    listchild = employee.getElementsByTagName("phone");
                    String phone = listchild.item(0).getTextContent();


                    if (!listSpinner.contains(tittle)) {
                        listSpinner.add(tittle);
                    }
                    list_listView.add(new Employee(tittle, id + " - " + name + " - " + phone));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private void readFileSAX(String strCacheFileName) {
        try {
            XmlPullParserFactory fc = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = fc.newPullParser();
            FileInputStream fileInputStream = openFileInput(strCacheFileName);
            xmlPullParser.setInput(fileInputStream, "UTF-8");
            int eventType = -1;
            String nodeName;
            String datashow = "";
            String datashowTitle = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                eventType = xmlPullParser.next();
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        nodeName = xmlPullParser.getName();

                        if (nodeName.equals("employee")) {
                            datashow += xmlPullParser.getAttributeValue(0) + " - ";
                            Toast.makeText(this, xmlPullParser.getAttributeValue(0) + "", Toast.LENGTH_SHORT).show();
                            if (!listSpinner.contains(xmlPullParser.getAttributeValue(1))) {
                                listSpinner.add(xmlPullParser.getAttributeValue(1));
                            }
                            datashowTitle = xmlPullParser.getAttributeValue(1);
                        }
                        if (nodeName.equals("name")) {
                            datashow += xmlPullParser.nextText() + " - ";
                        }
                        if (nodeName.equals("phone")) {

                            datashow += xmlPullParser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                list_listView.add(new Employee(datashowTitle, datashow));
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}