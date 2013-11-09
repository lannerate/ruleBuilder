package org.agilemore.agilegrid;

import java.util.Arrays;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;

public class r
{
  static final char a = '\t';
  static final String b = System.getProperty("line.separator");
  public v c;
  public w d;
  public x e;
  public y f;
  public z g;
  protected e h;
  protected MenuManager i;

  public r(e parame)
  {
    this.h = parame;
    b();
    c();
    this.i = new MenuManager("#PopupMenu");
    this.i.setRemoveAllWhenShown(true);
    this.i.addMenuListener(new s(this));
    Menu localMenu = this.i.createContextMenu(this.h);
    this.h.setMenu(localMenu);
  }

  public MenuManager a()
  {
    return this.i;
  }

  protected void b()
  {
    this.c = new v(this);
    this.d = new w(this);
    this.f = new y(this);
    this.e = new x(this);
    this.g = new z(this);
  }

  protected void a(IMenuManager paramIMenuManager)
  {
    paramIMenuManager.add(this.c);
    paramIMenuManager.add(this.e);
    paramIMenuManager.add(this.f);
    paramIMenuManager.add(new Separator());
    paramIMenuManager.add(this.d);
    paramIMenuManager.add(this.g);
    paramIMenuManager.add(new Separator());
  }

  protected void a(G[] paramArrayOfG)
  {
    TextTransfer localTextTransfer = TextTransfer.getInstance();
    HTMLTransfer localHTMLTransfer = HTMLTransfer.getInstance();
    String str1 = c(paramArrayOfG);
    String str2 = b(paramArrayOfG);
    Clipboard localClipboard = new Clipboard(this.h.getDisplay());
    try
    {
      localClipboard.setContents(new String[] { str1, str2 }, new Transfer[] { localTextTransfer, localHTMLTransfer });
    }
    catch (SWTError localSWTError)
    {
      if (localSWTError.code != 2002)
        throw localSWTError;
    }
    finally
    {
      localClipboard.dispose();
    }
  }

  private G[] f(G[] paramArrayOfG)
  {
    G localG1 = new G(this.h, -1, -1);
    G localG2 = new G(this.h, -1, -1);
    for (int j = 0; j < paramArrayOfG.length; j++)
    {
      G localG3 = paramArrayOfG[j];
      if (localG1.d < 0)
        localG1.d = localG3.d;
      else if (localG1.d > localG3.d)
        localG1.d = localG3.d;
      if (localG2.d < 0)
        localG2.d = localG3.d;
      else if (localG2.d < localG3.d)
        localG2.d = localG3.d;
      if (localG1.c < 0)
        localG1.c = localG3.c;
      else if (localG1.c > localG3.c)
        localG1.c = localG3.c;
      if (localG2.c < 0)
      {
        localG2.c = localG3.c;
      }
      else
      {
        if (localG2.c >= localG3.c)
          continue;
        localG2.c = localG3.c;
      }
    }
    return new G[] { localG1, localG2 };
  }

  private G a(int paramInt1, int paramInt2, au paramau)
  {
    G localG1 = new G(this.h, 1, 1);
    G localG2 = new G(this.h, paramInt1, paramInt2);
    while (paramau.a(paramInt2 + localG1.d, paramInt1).equals(localG2))
      localG1.d += 1;
    while (paramau.a(paramInt2, paramInt1 + localG1.c).equals(localG2))
      localG1.c += 1;
    return localG1;
  }

  protected String b(G[] paramArrayOfG)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    d(paramArrayOfG);
    G[] arrayOfG = f(paramArrayOfG);
    G localG1 = arrayOfG[0];
    G localG2 = arrayOfG[1];
    au localau = this.h.w();
    ar localar = this.h.j();
    if (localau == null)
      return "";
    localStringBuffer.append("Version:1.0\n");
    localStringBuffer.append("StartHTML:0000000000\n");
    localStringBuffer.append("EndHTML:0000000000\n");
    localStringBuffer.append("StartFragment:0000000000\n");
    localStringBuffer.append("EndFragment:0000000000\n");
    localStringBuffer.append("<html><body><table>");
    G localG3 = paramArrayOfG[0];
    int j = 1;
    for (int k = localG1.c; k <= localG2.c; k++)
    {
      localStringBuffer.append("<tr>");
      for (int m = localG1.d; m <= localG2.d; m++)
      {
        if (!localau.a(m, k).equals(new Point(m, k)))
          continue;
        if ((localG3.d == m) && (localG3.d == k))
        {
          localStringBuffer.append("<td");
          G localG4 = a(k, m, localau);
          if (localG4.c > 1)
            localStringBuffer.append(" rowspan=\"" + localG4.c + "\"");
          if (localG4.d > 1)
            localStringBuffer.append(" colspan=\"" + localG4.d + "\"");
          localStringBuffer.append(">");
          Object localObject = localar.b(m, k);
          localStringBuffer.append(a(localObject.toString()));
          if (j < paramArrayOfG.length)
          {
            localG3 = paramArrayOfG[j];
            j++;
          }
        }
        else
        {
          localStringBuffer.append("<td>");
        }
        localStringBuffer.append("</td>");
      }
      localStringBuffer.append("</tr>");
    }
    localStringBuffer.append("</table></body></html>");
    return localStringBuffer.toString();
  }

  private String a(String paramString)
  {
    paramString = paramString.replaceAll("&", "&amp;");
    paramString = paramString.replaceAll("锟�", "&auml;");
    paramString = paramString.replaceAll("锟�", "&Auml;");
    paramString = paramString.replaceAll("锟�", "&ouml;");
    paramString = paramString.replaceAll("锟�", "&Ouml;");
    paramString = paramString.replaceAll("锟�", "&uuml;");
    paramString = paramString.replaceAll("锟�", "&Uuml;");
    paramString = paramString.replaceAll("锟�", "&szlig;");
    paramString = paramString.replaceAll("\"", "&quot;");
    paramString = paramString.replaceAll("<", "&lt");
    paramString = paramString.replaceAll(">", "&gt");
    paramString = paramString.replaceAll("锟�", "&euro;");
    return paramString;
  }

  protected String c(G[] paramArrayOfG)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    G localG = d(paramArrayOfG);
    ar localar = this.h.j();
    if (localar == null)
      return "";
    int j = localG.d;
    for (int k = 0; k < paramArrayOfG.length; k++)
    {
      while (j < paramArrayOfG[k].d)
      {
        localStringBuffer.append('\t');
        j++;
      }
      Object localObject = localar.b(paramArrayOfG[k].c, paramArrayOfG[k].d);
      localStringBuffer.append(localObject.toString());
      if (k + 1 >= paramArrayOfG.length)
        continue;
      for (int m = paramArrayOfG[k].c; m < paramArrayOfG[(k + 1)].c; m++)
        localStringBuffer.append(b);
      if (paramArrayOfG[k].c == paramArrayOfG[(k + 1)].c)
        continue;
      j = localG.d;
    }
    return localStringBuffer.toString();
  }

  protected G d(G[] paramArrayOfG)
  {
    Arrays.sort(paramArrayOfG, new t(this));
    int j = paramArrayOfG[0].d;
    for (int k = 1; k < paramArrayOfG.length; k++)
    {
      if (paramArrayOfG[k].d >= j)
        continue;
      j = paramArrayOfG[k].d;
    }
    return new G(this.h, paramArrayOfG[0].c, j);
  }

  protected String e(G[] paramArrayOfG)
  {
    return c(paramArrayOfG);
  }

  protected void c()
  {
    this.h.a(new u(this));
  }

  protected void d()
  {
    this.c.a();
    this.d.a();
    this.e.a();
    this.f.b();
    this.g.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.r
 * JD-Core Version:    0.6.0
 */