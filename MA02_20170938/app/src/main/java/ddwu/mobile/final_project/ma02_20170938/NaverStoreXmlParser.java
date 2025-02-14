package ddwu.mobile.final_project.ma02_20170938;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class NaverStoreXmlParser {
    public enum TagType { NONE, TITLE, CATEGORY, DESCRIPTION, TEL, ADDRESS, ROADADDRESS, MAPX, MAPY };

    public NaverStoreXmlParser() {
    }

    public ArrayList<NaverStoreDto> parse(String xml){

        ArrayList<NaverStoreDto> resultList = new ArrayList<>();
        NaverStoreDto dto = null;

        TagType tagType = TagType.NONE;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xml));

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("item")) {
                            dto = new NaverStoreDto();
                        } else if (parser.getName().equals("title")) {
                            if (dto != null) tagType = TagType.TITLE;
                        } else if (parser.getName().equals("category")) {
                            if (dto != null) tagType = TagType.CATEGORY;
                        } else if (parser.getName().equals("telephone")) {
                            if (dto != null) tagType = TagType.TEL;
                        }else if (parser.getName().equals("address")) {
                            if (dto != null) tagType = TagType.ADDRESS;
                        }else if (parser.getName().equals("roadAddress")) {
                            if (dto != null) tagType = TagType.ROADADDRESS;
                        }else if (parser.getName().equals("mapx")) {
                            if (dto != null) tagType = TagType.MAPX;
                        }else if (parser.getName().equals("mapy")) {
                            if (dto != null) tagType = TagType.MAPY;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            resultList.add(dto);
                            dto = null;
                        }
                        break;
                    case XmlPullParser.TEXT:
                        switch(tagType) {
                            case TITLE:
                                dto.setTitle(parser.getText());
                                break;
                            case CATEGORY:
                                dto.setCategory(parser.getText());
                                break;
                            case TEL:
                                dto.setTelephone(parser.getText());
                                break;
                            case ADDRESS:
                                dto.setAddress(parser.getText());
                                break;
                            case ROADADDRESS:
                                dto.setRoadAddress(parser.getText());
                                break;
                            case MAPX:
                                dto.setMapx(Integer.parseInt(parser.getText()));
                                break;
                            case MAPY:
                                dto.setMapy(Integer.parseInt(parser.getText()));
                                break;
                        }
                        tagType = TagType.NONE;
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;

    }
}
