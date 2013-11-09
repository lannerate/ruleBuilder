package com.flagleader.builder.actions;

import java.util.Hashtable;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.StyledText;

class au
  implements Runnable
{
  au(aq paramaq, String paramString)
  {
  }

  public void run()
  {
    if ((!this.b.endsWith("\n")) && (!this.b.endsWith("\r")))
      aq.g(this.a).append(this.b + "\n");
    else
      aq.g(this.a).append(this.b);
    aq.g(this.a).setSelection(aq.g(this.a).getText().length());
    int i = this.b.indexOf(" : ");
    int j = this.b.indexOf(" : ", i + 4);
    if ((i > 0) && (j > 0))
      aq.h(this.a).put(String.valueOf(aq.g(this.a).getLineCount() - 2), this.b.substring(i + 3, j));
    aq.j(this.a).setSelection(3);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.au
 * JD-Core Version:    0.6.0
 */