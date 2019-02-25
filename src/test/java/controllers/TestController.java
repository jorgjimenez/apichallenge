package controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TestController {
    private static final String KEY ="0149e97b1f17867ccb1d1841865f76a7";
    private static final String TOKEN ="a101de921fd9de2320ec982d7f5253f0b524abafca63b2aebf80ca0d3559f27a";
    private static final String CONTENT_TYPE="";
    private String listToAddTheNewCard;
    private static final String ID = "5c48d85de5f8a01996d278ac";
    public static final String nameTODO="to do jorge";
    private static final String descTODO="jorge";
    private static final String idListTODO="5c48df6f2217f65db47d41e3";
    private static final String idListINPROGRESS="5c48df7736af565cff71a5cd";
    private static final String idListDONE="5c48df8007624036c8f61ba6";
    private static final String idcardTODO="5c744228cbd3ef6740ad3fba";

    public static Map<String,String> getAuthParams(){
        Map<String,String>params = new HashMap<>();
        params.put("key",KEY);
        params.put("token",TOKEN);
        return params;

    }

    public static URL getlistsInBoards()throws MalformedURLException {
        return new URL("https://api.trello.com/1/boards/"+ID +"/lists");
    }

    public static URL postCreateCard () throws  MalformedURLException{
        return new URL("https://api.trello.com/1/cards?name="+nameTODO+"&desc="+descTODO+"&idList="+idListTODO+"&keepFromSource=all&key="+KEY+"&token="+TOKEN+"");
    }
}
