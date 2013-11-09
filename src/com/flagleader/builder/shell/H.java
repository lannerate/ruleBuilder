package com.flagleader.builder.shell;

import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class H extends FocusAdapter
{
  H(G paramG, TableItem paramTableItem, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((!this.b.isDisposed()) && (!F.a(G.a(this.a)).isDisposed()))
    {
      String str = F.a(G.a(this.a)).getText();
      str = StringUtil.replace(FileUtil.newline, "\\n", str).trim();
      if (str.endsWith("\\n"))
        str = str.substring(0, str.length() - 2);
      if (!this.b.getText(this.c).equals(str))
        this.b.setText(this.c, str);
    }
    if ((F.a(G.a(this.a)) != null) && (!F.a(G.a(this.a)).isDisposed()))
    {
      F.a(G.a(this.a)).dispose();
      F.a(G.a(this.a), null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.H
 * JD-Core Version:    0.6.0
 */