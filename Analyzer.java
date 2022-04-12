/* Generated By:JavaCC: Do not edit this line. Analyzer.java */
import java.lang.*;
import java.util.HashMap;
import java.util.Map;

public class Analyzer implements AnalyzerConstants {
    static HashMap <String, Object> hashMap = new HashMap <String, Object> ();

    public static void main (String args[]) throws ParseException{
        Analyzer miniJavaAnalizer=new Analyzer(System.in);
        miniJavaAnalizer.Program();
        printTable();
                System.out.println("Compilacion exitosa");
    }


public static void insert(String id, String dataType, String category, String size){
    Symbol symbol = new Symbol(id , dataType, category, size);
    hashMap.put(id,symbol);
}

public static void busqueda(String id){
if (hashMap.containsKey(id)) {
    Symbol symbolFound = (Symbol) hashMap.get(id);
    System.out.println("Found: "+symbolFound.toString());
}else{
     System.out.println("Not found");
}
}


public static void delete(String id){
    hashMap.remove(id);
}

public static void printTable(){
    System.out.println("----------------------");
    System.out.println("TABLA DE SIMBOLOS: ");
    for (String i : hashMap.keySet()) {
        System.out.println(hashMap.get(i));
    }
}


public static class Symbol {
 String id, dataType, category, size;
        public Symbol(String id, String dataType, String category, String size){
                this.id=id;
                this.dataType=dataType;
        this.category=category;
        this.size=size;
        }

    String getId(){
        return id;
    }
    String getDataType(){
        return dataType;
    }
    String getCategory(){
        return category;
    }
    String getSize(){
        return size;
    }

    public String toString(){
    return getId()+ "-" + getDataType()+ "-" + getCategory()+ "-" + getSize();
  }
}

/*
*****************************SINTAXIS*****************************
*/
  static final public void Program() throws ParseException {
    MainClass();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case classToken:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      ClassDeclaration();
    }
    jj_consume_token(0);
  }

  static final public void MainClass() throws ParseException {
    jj_consume_token(classToken);
    jj_consume_token(idToken);
                       String image=token.image;
insert(image, "void", "clase", "0");
    jj_consume_token(openedCurlyBracketsToken);
    jj_consume_token(publicToken);
    jj_consume_token(staticToken);
    jj_consume_token(voidToken);
    jj_consume_token(mainToken);
    jj_consume_token(openedParenthesisToken);
    jj_consume_token(stringToken);
    jj_consume_token(openedBraceToken);
    jj_consume_token(closedBraceToken);
    jj_consume_token(idToken);
          image=token.image;
insert(image, "void", "arreglo", "0");
    jj_consume_token(closedParenthesisToken);
    jj_consume_token(openedCurlyBracketsToken);
    Statement();
    jj_consume_token(closedCurlyBracketsToken);
    jj_consume_token(closedCurlyBracketsToken);
  }

  static final public void ClassDeclaration() throws ParseException {
    jj_consume_token(classToken);
    jj_consume_token(idToken);
 String image=token.image;
insert(image, "void", "clase", "0");
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case extendsToken:
      jj_consume_token(extendsToken);
      jj_consume_token(idToken);
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(openedCurlyBracketsToken);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case stringToken:
      case intToken:
      case booleanToken:
      case floatToken:
      case idToken:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      VarDeclaration();
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case publicToken:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      MethodDeclaration();
    }
    jj_consume_token(closedCurlyBracketsToken);
  }

  static final public void VarDeclaration() throws ParseException {
                       String type; String image; int tam=0;
    type = Type();
    jj_consume_token(idToken);
 image=token.image;
if(type.equals("arreglo-float"))insert(image, "float", "arreglo", tam+"");
else if(type.equals("arreglo-int"))insert(image, "int", "arreglo", tam+"");
else insert(image, type, "variable", "0");
tam++;
    TwoOrMoreVar();
    jj_consume_token(semiColonToken);
  }

  static final public void TwoOrMoreVar() throws ParseException {
    label_4:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_4;
      }
      jj_consume_token(commaToken);
      jj_consume_token(idToken);
    }
  }

  static final public void MethodDeclaration() throws ParseException {
                          String type; int tam=0;
    jj_consume_token(publicToken);
    type = Type();
    jj_consume_token(idToken);
                                    String imageMethod=token.image;
    jj_consume_token(openedParenthesisToken);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case stringToken:
    case intToken:
    case booleanToken:
    case floatToken:
    case idToken:
      type = Type();
      jj_consume_token(idToken);
                                                String image=token.image;
if(type.equals("arreglo-float"))insert(image, "float", "arreglo", "0");
else if(type.equals("arreglo-int"))insert(image, "int", "arreglo", "0");
else insert(image, type, "variable", "0");
tam++;
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case commaToken:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_5;
        }
        jj_consume_token(commaToken);
        type = Type();
        jj_consume_token(idToken);
                                       image=token.image;
if(type.equals("arreglo-float"))insert(image, "float", "arreglo", "0");
else if(type.equals("arreglo-int"))insert(image, "int", "arreglo", "0");
else insert(image, type, "variable", "0");
tam++;
      }
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
 insert(imageMethod, type, "Funcion", tam+"");
    jj_consume_token(closedParenthesisToken);
    jj_consume_token(openedCurlyBracketsToken);
    label_6:
    while (true) {
      if (jj_2_2(2)) {
        ;
      } else {
        break label_6;
      }
      VarDeclaration();
    }
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ifToken:
      case whileToken:
      case soutToken:
      case openedCurlyBracketsToken:
      case idToken:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_7;
      }
      Statement();
    }
    jj_consume_token(returnToken);
    Expression();
    jj_consume_token(semiColonToken);
    jj_consume_token(closedCurlyBracketsToken);
  }

  static final public String Type() throws ParseException {
    if (jj_2_3(2)) {
      jj_consume_token(intToken);
      jj_consume_token(openedBraceToken);
      jj_consume_token(closedBraceToken);
                                                               {if (true) return "arreglo-int";}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case booleanToken:
        jj_consume_token(booleanToken);
                 {if (true) return "boolean";}
        break;
      case intToken:
        jj_consume_token(intToken);
                                                  {if (true) return "int";}
        break;
      default:
        jj_la1[7] = jj_gen;
        if (jj_2_4(2)) {
          jj_consume_token(floatToken);
                                                                                             {if (true) return "float";}
        } else {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case stringToken:
            jj_consume_token(stringToken);
                                                                                                                               {if (true) return "String";}
            break;
          case idToken:
            jj_consume_token(idToken);
            {if (true) return token.image;}
            break;
          case floatToken:
            jj_consume_token(floatToken);
            jj_consume_token(openedBraceToken);
            jj_consume_token(closedBraceToken);
                                                      {if (true) return "arreglo-float";}
            break;
          default:
            jj_la1[8] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case openedCurlyBracketsToken:
      jj_consume_token(openedCurlyBracketsToken);
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ifToken:
        case whileToken:
        case soutToken:
        case openedCurlyBracketsToken:
        case idToken:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_8;
        }
        Statement();
      }
      jj_consume_token(closedCurlyBracketsToken);
      break;
    case ifToken:
      jj_consume_token(ifToken);
      jj_consume_token(openedParenthesisToken);
      Expression();
      jj_consume_token(closedParenthesisToken);
      Statement();
      jj_consume_token(elseToken);
      Statement();
      break;
    case whileToken:
      jj_consume_token(whileToken);
      jj_consume_token(openedParenthesisToken);
      Expression();
      jj_consume_token(closedParenthesisToken);
      Statement();
      break;
    case soutToken:
      jj_consume_token(soutToken);
      jj_consume_token(openedParenthesisToken);
      Expression();
      jj_consume_token(closedParenthesisToken);
      jj_consume_token(semiColonToken);
      break;
    default:
      jj_la1[10] = jj_gen;
      if (jj_2_5(2)) {
        jj_consume_token(idToken);
        jj_consume_token(equalsToken);
        Expression();
        jj_consume_token(semiColonToken);
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case idToken:
          jj_consume_token(idToken);
          jj_consume_token(openedBraceToken);
          Expression();
          jj_consume_token(closedBraceToken);
          jj_consume_token(equalsToken);
          Expression();
          jj_consume_token(semiColonToken);
          break;
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  static final public void Expression() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case intConstToken:
      jj_consume_token(intConstToken);
      ExpressionPrime();
      break;
    case realConstToken:
      jj_consume_token(realConstToken);
      ExpressionPrime();
      break;
    case trueToken:
      jj_consume_token(trueToken);
      ExpressionPrime();
      break;
    case falseToken:
      jj_consume_token(falseToken);
      ExpressionPrime();
      break;
    case idToken:
      jj_consume_token(idToken);
      ExpressionPrime();
      break;
    case thisToken:
      jj_consume_token(thisToken);
      ExpressionPrime();
      break;
    default:
      jj_la1[12] = jj_gen;
      if (jj_2_6(2)) {
        jj_consume_token(newToken);
        jj_consume_token(intToken);
        jj_consume_token(openedBraceToken);
        Expression();
        jj_consume_token(closedBraceToken);
        ExpressionPrime();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case newToken:
          jj_consume_token(newToken);
          jj_consume_token(idToken);
          jj_consume_token(openedParenthesisToken);
          jj_consume_token(closedParenthesisToken);
          ExpressionPrime();
          break;
        case notToken:
          jj_consume_token(notToken);
          Expression();
          ExpressionPrime();
          break;
        case openedParenthesisToken:
          jj_consume_token(openedParenthesisToken);
          Expression();
          jj_consume_token(closedParenthesisToken);
          ExpressionPrime();
          break;
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  static final public void ExpressionPrime() throws ParseException {
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case openedBraceToken:
      case comparationToken:
      case andToken:
      case orToken:
      case lessThanToken:
      case moreThanToken:
      case lessOrEqualThanToken:
      case moreOrEqualThanToken:
      case plusToken:
      case minusToken:
      case multiplicationToken:
      case divisionToken:
      case dotToken:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_9;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case comparationToken:
      case andToken:
      case orToken:
      case lessThanToken:
      case moreThanToken:
      case lessOrEqualThanToken:
      case moreOrEqualThanToken:
      case plusToken:
      case minusToken:
      case multiplicationToken:
      case divisionToken:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case andToken:
          jj_consume_token(andToken);
          break;
        case orToken:
          jj_consume_token(orToken);
          break;
        case lessThanToken:
          jj_consume_token(lessThanToken);
          break;
        case moreThanToken:
          jj_consume_token(moreThanToken);
          break;
        case lessOrEqualThanToken:
          jj_consume_token(lessOrEqualThanToken);
          break;
        case moreOrEqualThanToken:
          jj_consume_token(moreOrEqualThanToken);
          break;
        case plusToken:
          jj_consume_token(plusToken);
          break;
        case minusToken:
          jj_consume_token(minusToken);
          break;
        case multiplicationToken:
          jj_consume_token(multiplicationToken);
          break;
        case divisionToken:
          jj_consume_token(divisionToken);
          break;
        case comparationToken:
          jj_consume_token(comparationToken);
          break;
        default:
          jj_la1[15] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Expression();
        ExpressionPrime();
        break;
      default:
        jj_la1[18] = jj_gen;
        if (jj_2_7(5)) {
          jj_consume_token(openedBraceToken);
          Expression();
          jj_consume_token(closedBraceToken);
          ExpressionPrime();
        } else if (jj_2_8(2)) {
          jj_consume_token(dotToken);
          jj_consume_token(lengthToken);
          ExpressionPrime();
        } else if (jj_2_9(2)) {
          jj_consume_token(dotToken);
          jj_consume_token(idToken);
          jj_consume_token(openedParenthesisToken);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case trueToken:
          case falseToken:
          case thisToken:
          case newToken:
          case openedParenthesisToken:
          case notToken:
          case idToken:
          case realConstToken:
          case intConstToken:
            Expression();
            label_10:
            while (true) {
              switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
              case commaToken:
                ;
                break;
              default:
                jj_la1[16] = jj_gen;
                break label_10;
              }
              jj_consume_token(commaToken);
              Expression();
            }
            break;
          default:
            jj_la1[17] = jj_gen;
            ;
          }
          jj_consume_token(closedParenthesisToken);
          ExpressionPrime();
        } else {
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  static private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  static private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  static private boolean jj_3_5() {
    if (jj_scan_token(idToken)) return true;
    if (jj_scan_token(equalsToken)) return true;
    return false;
  }

  static private boolean jj_3R_29() {
    if (jj_scan_token(floatToken)) return true;
    if (jj_scan_token(openedBraceToken)) return true;
    return false;
  }

  static private boolean jj_3R_28() {
    if (jj_scan_token(idToken)) return true;
    return false;
  }

  static private boolean jj_3R_25() {
    if (jj_scan_token(booleanToken)) return true;
    return false;
  }

  static private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3R_25()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3_4()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) return true;
    }
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_scan_token(intToken)) return true;
    if (jj_scan_token(openedBraceToken)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_scan_token(commaToken)) return true;
    if (jj_scan_token(idToken)) return true;
    return false;
  }

  static private boolean jj_3_4() {
    if (jj_scan_token(floatToken)) return true;
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_3R_14()) return true;
    if (jj_scan_token(idToken)) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3_9() {
    if (jj_scan_token(dotToken)) return true;
    if (jj_scan_token(idToken)) return true;
    if (jj_scan_token(openedParenthesisToken)) return true;
    return false;
  }

  static private boolean jj_3_7() {
    if (jj_scan_token(openedBraceToken)) return true;
    if (jj_3R_12()) return true;
    if (jj_scan_token(closedBraceToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3_8() {
    if (jj_scan_token(dotToken)) return true;
    if (jj_scan_token(lengthToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_26() {
    if (jj_scan_token(intToken)) return true;
    return false;
  }

  static private boolean jj_3R_24() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_3_7()) {
    jj_scanpos = xsp;
    if (jj_3_8()) {
    jj_scanpos = xsp;
    if (jj_3_9()) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_30() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(38)) {
    jj_scanpos = xsp;
    if (jj_scan_token(39)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(43)) {
    jj_scanpos = xsp;
    if (jj_scan_token(44)) {
    jj_scanpos = xsp;
    if (jj_scan_token(45)) {
    jj_scanpos = xsp;
    if (jj_scan_token(46)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(37)) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    if (jj_3R_12()) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_24()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3R_23() {
    if (jj_scan_token(openedParenthesisToken)) return true;
    if (jj_3R_12()) return true;
    if (jj_scan_token(closedParenthesisToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_21() {
    if (jj_scan_token(newToken)) return true;
    if (jj_scan_token(idToken)) return true;
    if (jj_scan_token(openedParenthesisToken)) return true;
    if (jj_scan_token(closedParenthesisToken)) return true;
    return false;
  }

  static private boolean jj_3R_22() {
    if (jj_scan_token(notToken)) return true;
    if (jj_3R_12()) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3_6() {
    if (jj_scan_token(newToken)) return true;
    if (jj_scan_token(intToken)) return true;
    if (jj_scan_token(openedBraceToken)) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3R_20() {
    if (jj_scan_token(thisToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    if (jj_scan_token(falseToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_19() {
    if (jj_scan_token(idToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_scan_token(trueToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_scan_token(realConstToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    if (jj_scan_token(intConstToken)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) {
    jj_scanpos = xsp;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_27() {
    if (jj_scan_token(stringToken)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public AnalyzerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  /** Whether we are looking ahead. */
  static private boolean jj_lookingAhead = false;
  static private boolean jj_semLA;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[19];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200,0x10000,0xe4000,0x400,0x0,0xe4000,0x8500000,0x60000,0x84000,0x8500000,0x8500000,0x0,0x3800000,0x84000000,0x20000000,0x0,0x0,0x87800000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x80000,0x0,0x20000,0x80000,0x80002,0x0,0x80000,0x80002,0x2,0x80000,0x380000,0x40000,0x1ffe0,0xffe0,0x20000,0x3c0000,0xffe0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[9];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Analyzer(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Analyzer(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AnalyzerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Analyzer(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalyzerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Analyzer(AnalyzerTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(AnalyzerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[59];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 19; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 59; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 9; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
