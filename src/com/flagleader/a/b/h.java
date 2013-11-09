package com.flagleader.a.b;

import com.flagleader.a.A;
import com.flagleader.a.B;
import com.flagleader.a.C;
import com.flagleader.a.D;
import com.flagleader.a.E;
import com.flagleader.a.F;
import com.flagleader.a.H;
import com.flagleader.a.J;
import com.flagleader.a.K;
import com.flagleader.a.L;
import com.flagleader.a.N;
import com.flagleader.a.P;
import com.flagleader.a.Q;
import com.flagleader.a.R;
import com.flagleader.a.S;
import com.flagleader.a.T;
import com.flagleader.a.U;
import com.flagleader.a.V;
import com.flagleader.a.W;
import com.flagleader.a.X;
import com.flagleader.a.Y;
import com.flagleader.a.aa;
import com.flagleader.a.ab;
import com.flagleader.a.ae;
import com.flagleader.a.af;
import com.flagleader.a.aj;
import com.flagleader.a.ak;
import com.flagleader.a.al;
import com.flagleader.a.d;
import com.flagleader.a.x;
import com.flagleader.a.z;
import com.flagleader.util.collection.ConcatenationIterator;
import com.flagleader.util.collection.ConcatenationList;
import com.flagleader.util.collection.DynamicIterator;
import com.flagleader.util.collection.IIterator;
import com.flagleader.util.collection.IList;
import java.io.Serializable;
import java.util.ArrayList;

public class h
  implements aj, Serializable
{
  private ArrayList a = new ArrayList();
  private static final String b = "visible";
  private static final String c = "false";
  private static h d = new h();

  public static aj a()
  {
    return d;
  }

  public ak c(J paramJ, String paramString)
  {
    if (paramString.startsWith("["))
    {
      for (int i = 1; paramString.startsWith("[", i); i++);
      if (paramString.length() > i)
        switch (paramString.charAt(i))
        {
        case 'E':
        case 'G':
        case 'H':
        case 'K':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        default:
          break;
        case 'B':
          return a(i, paramJ.h());
        case 'C':
          return a(i, paramJ.i());
        case 'D':
          return a(i, paramJ.o());
        case 'F':
          return a(i, paramJ.q());
        case 'I':
          return a(i, paramJ.r());
        case 'J':
          return a(i, paramJ.u());
        case 'S':
          return a(i, paramJ.z());
        case 'Z':
          return a(i, paramJ.f());
        case 'L':
          if (!paramString.endsWith(";"))
            break;
          int j = paramString.length() - 1;
          String str = paramString.substring(i + 1, j);
          S localS = paramJ.f(str);
          if (!(localS instanceof ak))
            break;
          return a(i, (ak)localS);
        }
    }
    return null;
  }

  private static boolean c(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }

  public static boolean a(char paramChar)
  {
    return (b(paramChar)) || (c(paramChar));
  }

  public static boolean b(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= ' ') && (paramChar <= 'ÿ')) || (paramChar == '_');
  }

  static N a(h paramh, B paramB)
  {
    return paramh.l(paramB);
  }

  static N a(h paramh, B paramB, E paramE, K paramK)
  {
    return paramh.c(paramB, paramE, paramK);
  }

  static boolean a(aa paramaa1, aa paramaa2)
  {
    return b(paramaa1, paramaa2);
  }

  public z a(B paramB)
  {
    i locali = new i(this, paramB);
    return new com.flagleader.a.b(locali);
  }

  public C a(J paramJ)
  {
    V localV = paramJ.m();
    if (localV != null)
      return localV.d();
    return new d(DynamicIterator.EmptyIterator());
  }

  public C a(V paramV)
  {
    n localn = new n(this, paramV);
    return new d(localn);
  }

  public z b(B paramB)
  {
    o localo = new o(this, paramB.k());
    return new com.flagleader.a.b(localo);
  }

  public N c(B paramB)
  {
    p localp = new p(this, paramB, paramB.k());
    return new com.flagleader.a.h(localp);
  }

  public Q d(B paramB)
  {
    q localq = new q(this, paramB.k());
    return new com.flagleader.a.j(localq);
  }

  public N e(B paramB)
  {
    r localr = new r(this, paramB);
    return new com.flagleader.a.h(localr);
  }

  public N a(B paramB, E paramE, K paramK)
  {
    Object localObject = new d(new ConcatenationIterator().addItem(paramB).addSubIterator(paramB.k()));
    if (paramK != null)
      localObject = com.flagleader.a.c.n.b((T)localObject, paramK);
    s locals = new s(this, (IIterator)localObject, paramB, paramE, paramK);
    return (N)new com.flagleader.a.h(locals);
  }

  public Q f(B paramB)
  {
    t localt = new t(this, paramB);
    return new com.flagleader.a.j(localt);
  }

  public W b(J paramJ)
  {
    com.flagleader.a.o localo = new com.flagleader.a.o();
    if (paramJ.m() != null)
      localo.add(paramJ.m());
    u localu = new u(this, localo);
    return new com.flagleader.a.n(localu);
  }

  public W b(V paramV)
  {
    j localj = new j(this, paramV);
    return new com.flagleader.a.n(localj);
  }

  public C g(B paramB)
  {
    k localk = new k(this, paramB);
    return new d(localk);
  }

  private void a(S paramS, StringBuffer paramStringBuffer)
  {
    af localaf = paramS.J();
    if ((localaf instanceof S))
    {
      int i = paramStringBuffer.length();
      a(localaf, paramStringBuffer);
      if (paramStringBuffer.length() > i)
        paramStringBuffer.append(".");
    }
    String str = paramS.L();
    if ((str != null) && (!str.equals("")))
      paramStringBuffer.append(str);
  }

  private void b(S paramS, StringBuffer paramStringBuffer)
  {
    Object localObject;
    if (d(paramS))
    {
      while (d(paramS))
      {
        paramStringBuffer.append("[");
        paramS = ((B)paramS).T();
      }
      if ((paramS instanceof ab))
      {
        localObject = (ab)paramS;
        if (((ab)localObject).f())
          paramStringBuffer.append("B");
        else if (((ab)localObject).g())
          paramStringBuffer.append("C");
        else if (((ab)localObject).h())
          paramStringBuffer.append("D");
        else if (((ab)localObject).i())
          paramStringBuffer.append("F");
        else if (((ab)localObject).j())
          paramStringBuffer.append("I");
        else if (((ab)localObject).k())
          paramStringBuffer.append("J");
        else if (((ab)localObject).n())
          paramStringBuffer.append("S");
        else if (((ab)localObject).e())
          paramStringBuffer.append("Z");
        else
          throw new RuntimeException("Invalid primitive type " + ((ab)localObject).L());
      }
      else
      {
        paramStringBuffer.append("L");
        b(paramS, paramStringBuffer);
        paramStringBuffer.append(";");
      }
    }
    else
    {
      localObject = paramS.J();
      if ((localObject instanceof S))
      {
        int i = paramStringBuffer.length();
        b((S)localObject, paramStringBuffer);
        if (paramStringBuffer.length() > i)
          if (((paramS instanceof B)) && ((localObject instanceof B)))
            paramStringBuffer.append("$");
          else
            paramStringBuffer.append(".");
      }
      String str = paramS.L();
      if ((str != null) && (!str.equals("")))
        paramStringBuffer.append(str);
    }
  }

  private static boolean b(aa paramaa1, aa paramaa2)
  {
    if ((paramaa1 == null) || (paramaa1.size() == 0))
      return (paramaa2 == null) || (paramaa2.size() == 0);
    if ((paramaa2 == null) || (paramaa2.size() == 0))
      return false;
    if (paramaa2.size() != paramaa1.size())
      return false;
    int i = paramaa2.size();
    for (int j = 0; j < i; j++)
    {
      ak localak1 = paramaa2.a(j).e();
      ak localak2 = paramaa1.a(j).e();
      if (localak1 != localak2)
        return false;
    }
    return true;
  }

  private static boolean a(aa paramaa, al paramal)
  {
    if ((paramaa == null) || (paramaa.size() == 0))
      return (paramal == null) || (!paramal.hasNext());
    if (paramal == null)
      return false;
    int i = paramaa.size();
    for (int j = 0; j < i; j++)
    {
      ak localak1 = paramaa.a(j).e();
      if (!paramal.hasNext())
        return false;
      ak localak2 = paramal.b();
      if (localak2 != localak1)
        return false;
    }
    return paramal.hasNext() ^ true;
  }

  private static boolean a(aa paramaa, ak[] paramArrayOfak)
  {
    if ((paramaa == null) || (paramaa.size() == 0))
      return (paramArrayOfak == null) || (paramArrayOfak.length == 0);
    if ((paramArrayOfak == null) || (paramArrayOfak.length == 0))
      return (paramaa == null) || (paramaa.size() == 0);
    if (paramArrayOfak.length != paramaa.size())
      return false;
    int i = paramArrayOfak.length;
    for (int j = 0; j < i; j++)
      if (paramArrayOfak[j] != paramaa.a(j).e())
        return false;
    return true;
  }

  private static boolean a(aa paramaa, Class[] paramArrayOfClass)
  {
    if ((paramaa == null) || (paramaa.size() == 0))
      return (paramArrayOfClass == null) || (paramArrayOfClass.length == 0);
    if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0))
      return (paramaa == null) || (paramaa.size() == 0);
    if (paramArrayOfClass.length != paramaa.size())
      return false;
    int i = paramArrayOfClass.length;
    for (int j = 0; j < i; j++)
      if (paramArrayOfClass[j] != paramaa.a(j).e().V())
        return false;
    return true;
  }

  private N l(B paramB)
  {
    ConcatenationList localConcatenationList = new ConcatenationList();
    localConcatenationList.addSubList(paramB.l());
    localConcatenationList.addSubList(paramB.q());
    return new com.flagleader.a.h(localConcatenationList.iterator());
  }

  private N c(B paramB, E paramE, K paramK)
  {
    Object localObject = l(paramB);
    if (paramK != null)
      localObject = com.flagleader.a.c.n.b((T)localObject, paramK);
    IList localIList = com.flagleader.a.c.j.a((IIterator)localObject, paramE);
    return (N)new com.flagleader.a.h(localIList.iterator());
  }

  public ak a(int paramInt, ak paramak)
  {
    while ((paramak != null) && (paramInt > 0))
    {
      paramak = paramak.S();
      paramInt--;
    }
    return paramak;
  }

  public ak a(J paramJ, String paramString)
  {
    int i = 0;
    while (paramString.endsWith("[]"))
    {
      i++;
      int j = paramString.length() - 2;
      paramString = paramString.substring(0, j);
    }
    S localS = paramJ.f(paramString);
    if ((localS instanceof ak))
      return a(i, (ak)localS);
    return null;
  }

  public F a(H paramH, ak[] paramArrayOfak)
  {
    return (F)a(paramH, null, paramArrayOfak);
  }

  public F a(H paramH, Class[] paramArrayOfClass)
  {
    return (F)a(paramH, null, paramArrayOfClass);
  }

  public B h(B paramB)
  {
    D localD = paramB.s();
    if (localD != null)
      for (int i = 0; i < localD.size(); i++)
        if (!localD.a(i).y())
          return localD.a(i);
    return null;
  }

  public B i(B paramB)
  {
    for (paramB = paramB.o(); (paramB != null) && (!paramB.O()); paramB = paramB.o());
    return paramB;
  }

  public String a(S paramS)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    a(paramS, localStringBuffer);
    return localStringBuffer.toString();
  }

  public String b(S paramS)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    b(paramS, localStringBuffer);
    return localStringBuffer.toString();
  }

  public P a(Q paramQ, String paramString, aa paramaa)
  {
    if (paramQ != null)
      while (paramQ.hasNext())
      {
        P localP = paramString == null ? paramQ.c() : paramQ.a(paramString);
        if ((localP != null) && (b(localP.g(), paramaa)))
          return localP;
      }
    return null;
  }

  public P a(Q paramQ, String paramString, al paramal)
  {
    if (paramQ != null)
      while (paramQ.hasNext())
      {
        P localP = paramString == null ? paramQ.c() : paramQ.a(paramString);
        if ((localP != null) && (a(localP.g(), paramal)))
          return localP;
      }
    return null;
  }

  public P a(Q paramQ, String paramString, ak[] paramArrayOfak)
  {
    if (paramQ != null)
      while (paramQ.hasNext())
      {
        P localP = paramString == null ? paramQ.c() : paramQ.a(paramString);
        if ((localP != null) && (a(localP.g(), paramArrayOfak)))
          return localP;
      }
    return null;
  }

  public P a(R paramR, String paramString, aa paramaa)
  {
    if (paramR != null)
    {
      int i = paramR.size();
      for (int j = 0; j < i; j++)
      {
        P localP = paramR.c(j);
        if (((paramString == null) || (paramString.equals(localP.L()))) && (b(localP.g(), paramaa)))
          return localP;
      }
    }
    return null;
  }

  public P a(R paramR, String paramString, ak[] paramArrayOfak)
  {
    if (paramR != null)
    {
      int i = paramR.size();
      for (int j = 0; j < i; j++)
      {
        P localP = paramR.c(j);
        if (((paramString == null) || (paramString.equals(localP.L()))) && (a(localP.g(), paramArrayOfak)))
          return localP;
      }
    }
    return null;
  }

  public P a(R paramR, String paramString, Class[] paramArrayOfClass)
  {
    if (paramR != null)
    {
      int i = paramR.size();
      for (int j = 0; j < i; j++)
      {
        P localP = paramR.c(j);
        if (((paramString == null) || (paramString.equals(localP.L()))) && (a(localP.g(), paramArrayOfClass)))
          return localP;
      }
    }
    return null;
  }

  public P b(R paramR, String paramString, ak[] paramArrayOfak)
  {
    if (paramR != null)
    {
      int i = paramR.size();
      for (int j = 0; j < i; j++)
      {
        P localP = paramR.c(j);
        String str = localP.H();
        if ((str != null) && ((paramString == null) || (paramString.equals(str))) && (a(localP.g(), paramArrayOfak)))
          return localP;
      }
    }
    return null;
  }

  public S a(af paramaf, String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      int i = paramString.indexOf(".");
      String str;
      if (i >= 1)
      {
        str = paramString.substring(0, i);
        paramString = paramString.substring(i + 1);
      }
      else
      {
        str = paramString;
        paramString = null;
      }
      T localT = paramaf.P();
      S localS = localT == null ? null : localT.e(str);
      if ((paramString == null) || (paramString.equals("")))
        return localS;
      if ((localS instanceof af))
        return a((af)localS, paramString);
      return null;
    }
    return paramaf;
  }

  public S b(J paramJ, String paramString)
  {
    if (paramString != null)
    {
      ab localab = paramJ.j(paramString);
      if (localab != null)
        return localab;
      if (paramString.endsWith("[]"))
        return a(paramJ, paramString);
      V localV = paramJ.m();
      return a(localV, paramString);
    }
    return null;
  }

  public S a(U paramU, String paramString)
  {
    if (paramU != null)
    {
      int i = paramU.size();
      for (int j = 0; j < i; j++)
      {
        S localS = paramU.d(j);
        String str = localS.H();
        if (str == null)
          str = localS.L();
        if (paramString != null ? paramString.equals(str) : str == null)
          return localS;
      }
    }
    return null;
  }

  public P a(P paramP, K paramK)
  {
    if (paramP.q())
    {
      B localB = paramP.h();
      Object localObject1 = localB.k();
      if (paramK != null)
        localObject1 = com.flagleader.a.c.n.b((T)localObject1, paramK);
      Object localObject2 = new com.flagleader.a.l(new l(this, (IIterator)localObject1));
      if (paramK != null)
        localObject2 = com.flagleader.a.c.n.b((T)localObject2, paramK);
      com.flagleader.a.j localj = new com.flagleader.a.j((IIterator)localObject2);
      return a(localj, paramP.L(), paramP.g());
    }
    return (P)(P)null;
  }

  public static Q a(B paramB, K paramK)
  {
    y localy = paramB.y() ? paramB.h() : new y(paramB);
    ConcatenationIterator localConcatenationIterator = new ConcatenationIterator();
    localConcatenationIterator.addItem(paramB);
    localConcatenationIterator.addSubIterator((IIterator)localy);
    Object localObject1 = localConcatenationIterator;
    if (paramK != null)
      localObject1 = com.flagleader.a.c.n.b(new com.flagleader.a.l((IIterator)localObject1), paramK);
    Object localObject2 = new com.flagleader.a.l(new m((IIterator)localObject1));
    if (paramK != null)
      localObject2 = com.flagleader.a.c.n.b((T)localObject2, paramK);
    return (Q)(Q)new com.flagleader.a.j(new v((IIterator)localObject2));
  }

  public P b(P paramP, K paramK)
  {
    P localP;
    for (paramP = paramP.a(paramK); paramP != null; paramP = localP)
    {
      localP = paramP.a(paramK);
      if (localP == null)
        return paramP;
    }
    return null;
  }

  private boolean d(S paramS)
  {
    if ((paramS instanceof B))
    {
      B localB = (B)paramS;
      return localB.W();
    }
    return false;
  }

  public boolean a(ak paramak1, ak paramak2)
  {
    return a(paramak2, paramak1, 1);
  }

  private boolean a(ak paramak1, ak paramak2, int paramInt)
  {
    J localJ = paramak2.M();
    if (paramak2 == paramak1)
      return true;
    if ((paramak2.Y()) || (paramak1.Y()))
      return false;
    if (paramak1.Z())
    {
      if (paramak2.Z())
      {
        localObject1 = (ab)paramak2;
        localObject2 = (ab)paramak1;
        if (paramInt == 2)
          return (((ab)localObject1).a((ab)localObject2)) || (((ab)localObject2).a((ab)localObject1));
        return ((ab)localObject1).a((ab)localObject2);
      }
      return false;
    }
    if (paramak2.Z())
      return false;
    Object localObject1 = (B)paramak1;
    Object localObject2 = (B)paramak2;
    if (((B)localObject1).W())
    {
      if (((B)localObject2).W())
      {
        ak localak1 = ((B)localObject2).T();
        ak localak2 = ((B)localObject1).T();
        if (((localak2.Z()) || (localak1.Z())) && (localak2 != localak1))
          return false;
        return a(localak2, localak1, paramInt);
      }
      return (localJ.a((B)localObject2)) || (localJ.b((B)localObject2));
    }
    if (((B)localObject2).W())
      return (localJ.a((B)localObject1)) || (localJ.b((B)localObject1));
    if (((B)localObject1).y())
    {
      if (paramInt == 2)
      {
        if (((B)localObject2).y())
          return true;
        if (((B)localObject2).w())
          return ((B)localObject2).a((B)localObject1);
        return true;
      }
      return (((B)localObject1).a((B)localObject2)) || (localJ.b((B)localObject2));
    }
    if (((B)localObject2).y())
    {
      if (paramInt == 2)
      {
        if (((B)localObject1).w())
          return ((B)localObject1).a((B)localObject2);
        return true;
      }
      return ((B)localObject1).a((B)localObject2);
    }
    return (((B)localObject1).a((B)localObject2)) || ((paramInt == 2) && (((B)localObject2).a((B)localObject1)));
  }

  public boolean b(ak paramak1, ak paramak2)
  {
    return a(paramak1, paramak2, 2);
  }

  public boolean a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0) && (b(paramString.charAt(0))))
    {
      for (int i = 1; i < paramString.length(); i++)
      {
        char c1 = paramString.charAt(i);
        if (!a(c1))
          return false;
      }
      return true;
    }
    return false;
  }

  public boolean a(B paramB1, B paramB2)
  {
    C localC = g(paramB1);
    while (localC.hasNext())
      if (localC.a() == paramB2)
        return true;
    return false;
  }

  public boolean c(S paramS)
  {
    Object localObject = paramS.a("visible");
    return (!(localObject instanceof String)) || (!((String)localObject).equals("false"));
  }

  public static String b(String paramString)
  {
    String str = paramString;
    if (str.endsWith("[]"))
    {
      int i = str.length();
      str = str.substring(0, i - 2);
      i -= 2;
      int j = 1;
      while (str.endsWith("[]"))
      {
        j++;
        str = str.substring(0, i - 2);
        i -= 2;
      }
      StringBuffer localStringBuffer = new StringBuffer();
      while (j-- > 0)
        localStringBuffer.append('[');
      switch (str.charAt(0))
      {
      case 'b':
        if ("byte".equals(str))
          return a(localStringBuffer, str, "byte", 'B', str);
        return a(localStringBuffer, str, "boolean", 'Z', str);
      case 'c':
        return a(localStringBuffer, str, "char", 'C', str);
      case 'd':
        return a(localStringBuffer, str, "double", 'D', str);
      case 'f':
        return a(localStringBuffer, str, "float", 'F', str);
      case 'i':
        return a(localStringBuffer, str, "int", 'I', str);
      case 'l':
        return a(localStringBuffer, str, "long", 'J', str);
      case 's':
        return a(localStringBuffer, str, "short", 'S', str);
      case 'e':
      case 'g':
      case 'h':
      case 'j':
      case 'k':
      case 'm':
      case 'n':
      case 'o':
      case 'p':
      case 'q':
      case 'r':
      }
      return a(localStringBuffer, str);
    }
    return paramString;
  }

  public static String c(String paramString)
  {
    if (paramString.startsWith("["))
    {
      for (int i = 1; paramString.startsWith("[", i); i++);
      if (paramString.length() > i)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        switch (paramString.charAt(i))
        {
        case 'B':
          localStringBuffer.append("byte");
          break;
        case 'C':
          localStringBuffer.append("char");
          break;
        case 'D':
          localStringBuffer.append("double");
          break;
        case 'F':
          localStringBuffer.append("float");
          break;
        case 'I':
          localStringBuffer.append("int");
          break;
        case 'J':
          localStringBuffer.append("long");
          break;
        case 'S':
          localStringBuffer.append("short");
          break;
        case 'Z':
          localStringBuffer.append("boolean");
          break;
        case 'L':
          if (paramString.endsWith(";"))
          {
            j = paramString.length() - 1;
            String str = paramString.substring(i + 1, j);
            localStringBuffer.append(str.replace('$', '.'));
          }
          else
          {
            return paramString;
          }
        case 'E':
        case 'G':
        case 'H':
        case 'K':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        default:
          return paramString;
        }
        for (int j = 0; j < i; j++)
          localStringBuffer.append("[]");
        return localStringBuffer.toString();
      }
    }
    return paramString.replace('$', '.');
  }

  private static String a(StringBuffer paramStringBuffer, String paramString)
  {
    paramStringBuffer.append('L');
    paramStringBuffer.append(paramString);
    paramStringBuffer.append(';');
    return paramStringBuffer.toString();
  }

  private static String a(StringBuffer paramStringBuffer, String paramString1, String paramString2, char paramChar, String paramString3)
  {
    if (paramString2.equals(paramString1))
    {
      paramStringBuffer.append(paramChar);
      return paramStringBuffer.toString();
    }
    return a(paramStringBuffer, paramString3);
  }

  public N j(B paramB)
  {
    ConcatenationList localConcatenationList = new ConcatenationList();
    localConcatenationList.addSubList(paramB.l());
    localConcatenationList.addSubList(paramB.n());
    localConcatenationList.addSubList(paramB.q());
    return new com.flagleader.a.h(localConcatenationList.iterator());
  }

  public N b(B paramB, E paramE, K paramK)
  {
    Object localObject = paramB.E();
    if (paramK != null)
      localObject = com.flagleader.a.c.n.b((T)localObject, paramK);
    IList localIList = com.flagleader.a.c.j.a((IIterator)localObject, paramE);
    return (N)new com.flagleader.a.h(localIList.iterator());
  }

  public al k(B paramB)
  {
    x localx = new x();
    localx.add(paramB);
    com.flagleader.a.c.b localb = new com.flagleader.a.c.b(paramB.M(), com.flagleader.a.c.n.a, localx.b());
    return localb.a();
  }

  public void a(ae paramae1, String paramString, ae paramae2)
  {
    paramae1.a(paramString, paramae2);
  }

  public void a(S paramS, boolean paramBoolean)
  {
    if (paramBoolean)
      paramS.c("visible");
    else
      paramS.a("visible", "false");
  }

  public boolean a(L paramL, com.flagleader.a.y paramy)
  {
    return a(paramL, paramy.e());
  }

  public boolean a(L paramL, B paramB)
  {
    return (g(paramL, paramB)) && (f(paramL, paramB)) && (b(paramL, paramB)) && (c(paramL, paramB)) && (e(paramL, paramB));
  }

  public boolean b(L paramL, B paramB)
  {
    A localA = paramB.l();
    if (localA != null)
      for (int i = 0; i < localA.size(); i++)
        if (!paramL.a(localA.a(i)))
          return false;
    return true;
  }

  public boolean c(L paramL, B paramB)
  {
    H localH = paramB.n();
    if (localH != null)
      for (int i = 0; i < localH.size(); i++)
        if (!paramL.a(localH.a(i)))
          return false;
    return true;
  }

  public boolean d(L paramL, B paramB)
  {
    af localaf = paramB.J();
    return (!(localaf instanceof B)) || (paramL.a((B)localaf));
  }

  public boolean e(L paramL, B paramB)
  {
    R localR = paramB.q();
    if (localR != null)
      for (int i = 0; i < localR.size(); i++)
        if (!paramL.a(localR.c(i)))
          return false;
    return true;
  }

  public boolean f(L paramL, B paramB)
  {
    D localD = paramB.r();
    if (localD != null)
      for (int i = 0; i < localD.size(); i++)
        if ((!this.a.contains(localD.a(i))) && (!paramL.a(localD.a(i))))
          return false;
    return true;
  }

  public boolean g(L paramL, B paramB)
  {
    D localD = paramB.s();
    this.a.add(paramB);
    if (localD != null)
      for (int i = 0; i < localD.size(); i++)
        if (!paramL.a(localD.a(i)))
          return false;
    this.a.remove(paramB);
    return true;
  }

  public boolean a(L paramL, P paramP)
  {
    return (d(paramL, paramP)) && (c(paramL, paramP)) && (b(paramL, paramP));
  }

  public boolean b(L paramL, P paramP)
  {
    D localD = paramP.e();
    if (localD != null)
      for (int i = 0; i < localD.size(); i++)
        if (!paramL.a(localD.a(i)))
          return false;
    return true;
  }

  public boolean c(L paramL, P paramP)
  {
    aa localaa = paramP.g();
    if (localaa != null)
      for (int i = 0; i < localaa.size(); i++)
      {
        Y localY = localaa.a(i);
        if (!a(paramL, localY.e()))
          return false;
      }
    return true;
  }

  public boolean d(L paramL, P paramP)
  {
    return a(paramL, paramP.n());
  }

  public boolean a(L paramL, J paramJ)
  {
    V localV = paramJ.m();
    if (localV != null)
      return paramL.a(localV);
    return true;
  }

  public boolean a(L paramL, V paramV)
  {
    return (b(paramL, paramV)) && (c(paramL, paramV));
  }

  public boolean b(L paramL, V paramV)
  {
    D localD = paramV.f();
    if (localD != null)
      for (int i = 0; i < localD.size(); i++)
        if (!paramL.a(localD.a(i)))
          return false;
    return true;
  }

  public boolean c(L paramL, V paramV)
  {
    X localX = paramV.h();
    if (localX != null)
      for (int i = 0; i < localX.size(); i++)
        if (!paramL.a(localX.a(i)))
          return false;
    return true;
  }

  private static boolean a(L paramL, ak paramak)
  {
    return (!paramak.X()) || (paramL.a((B)paramak));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.h
 * JD-Core Version:    0.6.0
 */