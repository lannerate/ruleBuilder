package org.agilemore.agilegrid;

import java.util.Vector;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;

public class y extends Action
{
  protected y(r paramr)
  {
    setId("AgileGridPasteActionHandler");
    setEnabled(false);
    setText("Paste");
  }

  public void run()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()))
      a(a(), this.a.h.y());
  }

  protected String a()
  {
    Clipboard localClipboard = new Clipboard(this.a.h.getDisplay());
    try
    {
      String str = localClipboard.getContents(TextTransfer.getInstance()).toString();
      return str;
    }
    catch (Exception localException)
    {
      return "";
    }
    finally
    {
      localClipboard.dispose();
    }
    throw localObject;
  }

  protected void a(String paramString, G[] paramArrayOfG)
  {
    if ((paramArrayOfG == null) || (paramArrayOfG.length == 0))
      return;
    ar localar = this.a.h.j();
    if (localar == null)
      return;
    try
    {
      this.a.h.setRedraw(false);
      this.a.h.z();
      Vector localVector = new Vector();
      String[][] arrayOfString = a(paramString);
      for (int i = 0; i < arrayOfString.length; i++)
        for (int j = 0; j < arrayOfString[i].length; j++)
        {
          localar.b(i + paramArrayOfG[0].c, j + paramArrayOfG[0].d, arrayOfString[i][j]);
          localVector.add(new G(this.a.h, i + paramArrayOfG[0].c, j + paramArrayOfG[0].d));
        }
      this.a.h.b((G[])localVector.toArray(new G[0]));
    }
    finally
    {
      this.a.h.setRedraw(true);
    }
  }

  protected String[][] a(String paramString)
  {
    if (!this.a.h.h())
      return new String[][] { { paramString } };
    String[] arrayOfString = paramString.split(r.b);
    String[][] arrayOfString; = new String[arrayOfString.length][];
    for (int i = 0; i < arrayOfString.length; i++)
      arrayOfString;[i] = arrayOfString[i].split("\t");
    return arrayOfString;;
  }

  public void b()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()))
    {
      G[] arrayOfG = this.a.h.y();
      if (arrayOfG == null)
        setEnabled(false);
      else if (arrayOfG.length > 1)
        setEnabled(false);
      else
        setEnabled(true);
    }
    else
    {
      setEnabled(false);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.y
 * JD-Core Version:    0.6.0
 */