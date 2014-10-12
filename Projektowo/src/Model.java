import java.io.FileOutputStream;
import java.util.Random;
import javax.swing.JOptionPane;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSSerializer;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Model {
    int zakres;
	Random r = new Random();
	int liczba=r.nextInt(set());
	
	char karty[]={'0','A','2','3','4','5','6','7','8','9','d','W','D','K'};
	
	String imie;
	int proby;
	static int jeden,dwa, trzy, cztery, piec;
        static String pierwsze, drugie,trzecie,czwarte, piate;
	Model(){
	System.out.println("wylosowana karta: " + karty[liczba]);
	}

	String getimie(){
		return imie;
	}
        
	public static Document document;
        
	int porownaj(String s){
		
		char tmp = s.charAt(0);
		int tmpliczba = tmp;
		if(tmp=='A')tmpliczba=1;
		
		if(tmp=='2')tmpliczba=2;
		if(tmp=='3')tmpliczba=3;
		if(tmp=='4')tmpliczba=4;
		if(tmp=='5')tmpliczba=5;
		if(tmp=='6')tmpliczba=6;
		if(tmp=='7')tmpliczba=7;
		if(tmp=='8')tmpliczba=8;
		if(tmp=='9')tmpliczba=9;
		if(tmp=='d')tmpliczba=10;
		
		if(tmp=='W')tmpliczba=11;
		if(tmp=='D')tmpliczba=12;
		if(tmp=='K')tmpliczba=13;
		
		if (tmpliczba==liczba){
			System.out.println("podana karta i wylosowana sa rowne!");
			return 0;
		}
		else if(tmpliczba<liczba){
				System.out.println(tmpliczba+" < "+liczba);
				
				return 1;	
				}
			else{
				System.out.println(tmpliczba+" > "+liczba);
			return -1;
			}		
	}
	
      	public int set() {  
        try {

			System.setProperty(DOMImplementationRegistry.PROPERTY,"org.apache.xerces.dom.DOMXSImplementationSourceImpl");
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			LSParser builder = impl.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
			DOMConfiguration config = builder.getDomConfig();
			DOMErrorHandler errorHandler = getErrorHandler();
			config.setParameter("error-handler", errorHandler);
			config.setParameter("validate", Boolean.TRUE);
			config.setParameter("schema-type","http://www.w3.org/2001/XMLSchema");
			config.setParameter("schema-location", "ranked.xsd");
			// sparsowanie dokumentu i pozyskanie "document" do dalszej pracy
			document = builder.parseURI("src\\db.xml");
                        Element elem = document.getDocumentElement();
			//Element newElem = (Element) elem.cloneNode(true);
			//newElem.setAttribute("id", "six.worker");
			NodeList nl = elem.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
                                if (n.getNodeName().equals("do")) {
                                zakres =  Integer.parseInt(n.getTextContent());
				//proby =	Integer.parseInt(n.getTextContent());
                                        
				}
                        }
        		} catch (Exception ex) {
			ex.printStackTrace();
		}
return zakres;
	}
        
      	public int odczyt() {  
        try {

			System.setProperty(DOMImplementationRegistry.PROPERTY,"org.apache.xerces.dom.DOMXSImplementationSourceImpl");
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			LSParser builder = impl.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
			DOMConfiguration config = builder.getDomConfig();
			DOMErrorHandler errorHandler = getErrorHandler();
			config.setParameter("error-handler", errorHandler);
			config.setParameter("validate", Boolean.TRUE);
			config.setParameter("schema-type","http://www.w3.org/2001/XMLSchema");
			config.setParameter("schema-location", "ranked.xsd");
			// sparsowanie dokumentu i pozyskanie "document" do dalszej pracy
			document = builder.parseURI("src\\db.xml");
                        Element elem = document.getDocumentElement();
			//Element newElem = (Element) elem.cloneNode(true);
			//newElem.setAttribute("id", "six.worker");
			NodeList nl = elem.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
                                //System.out.println(i);
                                if (n.getNodeName().equals("do")) {
                                zakres =  Integer.parseInt(n.getTextContent());
                                   // System.out.println("do");
				//proby =	Integer.parseInt(n.getTextContent());
                                        
				}
				if (n.getNodeName().equals("proby")) {
                                   proby =  Integer.parseInt(n.getTextContent());
				}
                                if (n.getNodeName().equals("first")) {
                                   jeden =  Integer.parseInt(n.getTextContent());
                                   
				}
                                if (n.getNodeName().equals("second")) {
                                   dwa =  Integer.parseInt(n.getTextContent());
				}
                                if (n.getNodeName().equals("third")) {
                                   trzy =  Integer.parseInt(n.getTextContent());
				}
                                if (n.getNodeName().equals("fourth")) {
                                   cztery =  Integer.parseInt(n.getTextContent());
				}
                                if (n.getNodeName().equals("fifth")) {
                                   piec =  Integer.parseInt(n.getTextContent());
				}
                                
                                if (n.getNodeName().equals("nickone")) {                                       
                                    pierwsze = n.getTextContent();     
    				}
                                    if (n.getNodeName().equals("nicktwo")) {                                       
                                    	 drugie = n.getTextContent();    
    				}
                                    if (n.getNodeName().equals("nickthree")) {                                       
                                    	 trzecie = n.getTextContent();     
    				}
                                    if (n.getNodeName().equals("nickfour")) {                                       
                                    	 czwarte = n.getTextContent();    
    				}
                                    if (n.getNodeName().equals("nickfive")) {                                       
                                    	 piate = n.getTextContent();    
    				}     
    				
                                

			}
		//	document.getFirstChild().setNodeValue();

			// pozyskanie serializatora
			LSSerializer domWriter = impl.createLSSerializer();
			// pobranie konfiguratora dla serializatora
			config = domWriter.getDomConfig();
			config.setParameter("xml-declaration", Boolean.TRUE);

			// pozyskanie i konfiguracja Wyjscia
			LSOutput dOut = impl.createLSOutput();
			dOut.setEncoding("latin2");
			dOut.setByteStream(new FileOutputStream("src\\db.xml"));

			//System.out.println("Serializing document... ");
			domWriter.write(document, dOut);

			// Wyjscie na ekran
			// dOut.setByteStream(System.out);
			// domWriter.writeNode(System.out, document);
                        
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        return proby;
	}
        
        void zapis (int proby, String osoba){
                try {
                    
			System.setProperty(DOMImplementationRegistry.PROPERTY,"org.apache.xerces.dom.DOMXSImplementationSourceImpl");
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();

			// pozyskanie implementacji Load & Save DOM Level 3 z rejestru
			DOMImplementationLS impl = (DOMImplementationLS) registry
					.getDOMImplementation("LS");

			// stworzenie DOMBuilder
			LSParser builder = impl.createLSParser(
					DOMImplementationLS.MODE_SYNCHRONOUS, null);

			// pozyskanie konfiguratora - koniecznie zajrzec do dokumentacji co
			// mozna poustawiac
			DOMConfiguration config = builder.getDomConfig();

			// stworzenie DOMErrorHandler i zarejestrowanie w konfiguratorze
			DOMErrorHandler errorHandler = getErrorHandler();
			config.setParameter("error-handler", errorHandler);

			// set validation feature
			config.setParameter("validate", Boolean.TRUE);

			// set schema language
			config.setParameter("schema-type","http://www.w3.org/2001/XMLSchema");

			// set schema location
			config.setParameter("schema-location", "ranked.xsd");

			//System.out.println("Parsowanie...");
			// sparsowanie dokumentu i pozyskanie "document" do dalszej pracy
			document = builder.parseURI("src\\db.xml");

			// praca z dokumentem, modyfikacja zawartosci etc... np.
                        Element elem = document.getDocumentElement();
			NodeList nl = elem.getChildNodes();
                        liczba=proby;
                                if(liczba<=jeden){
                                    piec=cztery; piate=czwarte;
                                    cztery=trzy; czwarte = trzecie;
                                    trzy=dwa; trzecie = drugie;
                                    dwa=jeden; drugie = pierwsze;
                                    jeden=liczba;  pierwsze = imie;
                                    JOptionPane.showMessageDialog(null, "PIERWSZE MIEJSCE!");
                                }
                                else{ if(liczba<=dwa){
                                    piec=cztery; piate=czwarte;
                                    cztery=trzy; czwarte = trzecie;
                                    trzy=dwa; trzecie = drugie;
                                    dwa=liczba; drugie = imie;

                                    JOptionPane.showMessageDialog(null, "DRUGIE MIEJSCE!");
    
                                }
                                else {if(liczba<=trzy){
                                    piec=cztery; piate=czwarte;
                                    cztery=trzy; czwarte = trzecie;
                                    trzy=liczba; trzecie = imie;

                                    JOptionPane.showMessageDialog(null, "TRZECIE MIEJSCE!");
                                }
                                else {if(liczba<=cztery)
                                {
                                    piec=cztery; piate=czwarte;
                                    cztery=liczba; czwarte = imie;

                                    JOptionPane.showMessageDialog(null, "CZWARTE MIEJSCE!");
                                }
                                else {if(liczba<=piec)
                                {
                                    piec=liczba; piate = imie;

                                    JOptionPane.showMessageDialog(null, "PIATE MIEJSCE!");
                                }
                                }}}}
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
                               // System.out.println(liczba);
                               // System.out.println(n);
                               // System.err.println("ILE PROB"+proby);

                                
                                if (n.getNodeName().equals("first")) {                                       
                                n.setTextContent(String.valueOf(jeden));     
				}
                                if (n.getNodeName().equals("second")) {                                       
                                n.setTextContent(String.valueOf(dwa));     
				}
                                if (n.getNodeName().equals("third")) {                                       
                                n.setTextContent(String.valueOf(trzy));     
				}
                                if (n.getNodeName().equals("fourth")) {                                       
                                n.setTextContent(String.valueOf(cztery));     
				}
                                if (n.getNodeName().equals("fifth")) {                                       
                                n.setTextContent(String.valueOf(piec));  
				}

                                if (n.getNodeName().equals("nickone")) {                                       
                                n.setTextContent(pierwsze);     
				}
                                if (n.getNodeName().equals("nicktwo")) {                                       
                                n.setTextContent(drugie);     
				}
                                if (n.getNodeName().equals("nickthree")) {                                       
                                n.setTextContent(trzecie);     
				}
                                if (n.getNodeName().equals("nickfour")) {                                       
                                n.setTextContent(czwarte);     
				}
                                if (n.getNodeName().equals("nickfive")) {                                       
                                n.setTextContent(piate);     
				}     
				
                                
			}
		//	document.getFirstChild().setNodeValue();

			// pozyskanie serializatora
			LSSerializer domWriter = impl.createLSSerializer();
			// pobranie konfiguratora dla serializatora
			config = domWriter.getDomConfig();
			config.setParameter("xml-declaration", Boolean.TRUE);

			// pozyskanie i konfiguracja Wyjscia
			LSOutput dOut = impl.createLSOutput();
			dOut.setEncoding("latin2");
			dOut.setByteStream(new FileOutputStream("src\\db.xml"));

			//System.out.println("Serializing document... ");
			domWriter.write(document, dOut);

			// Wyjscie na ekran
			// dOut.setByteStream(System.out);
			// domWriter.writeNode(System.out, document);
              Prit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
        	public static DOMErrorHandler getErrorHandler() {
		return new DOMErrorHandler() {
			public boolean handleError(DOMError error) {
				short severity = error.getSeverity();
				if (severity == DOMError.SEVERITY_ERROR) {
					System.out.println("[dom3-error]: " + error.getMessage());
				}
				if (severity == DOMError.SEVERITY_WARNING) {
					System.out.println("[dom3-warning]: " + error.getMessage());
				}
				if (severity == DOMError.SEVERITY_FATAL_ERROR) {
					System.out.println("[dom3-fatal-error]: "+ error.getMessage());
				}
				return true;
			}
		};
	}

			public static void Prit() {
				String do_wyslania = "";
				do_wyslania += pierwsze + " " + jeden + "\n" 
							+ drugie + " " + dwa + "\n" 
							+ trzecie + " " + trzy + "\n" 
							+ czwarte + " " + cztery + "\n" 
							+ piate + " " + piec;
			JOptionPane.showMessageDialog(null,do_wyslania );
			}

}
