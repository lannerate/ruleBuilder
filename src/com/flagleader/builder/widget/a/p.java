package com.flagleader.builder.widget.a;

import com.flagleader.repository.export.Tag;
import java.util.List;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class p extends SelectionAdapter
{
  p(k paramk, Tag paramTag, StyledText paramStyledText, String paramString)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String str = "";
    for (int i = 0; i < this.b.getAttributes().size(); i++)
      str = str + " " + this.b.getAttributes().get(i).toString() + "=\"\"";
    if (this.b.getPostCode().length() > 0)
      this.c.insert("<rsp:" + this.d + str + " ></rsp:" + this.d + ">");
    else
      this.c.insert("<rsp:" + this.d + str + " />");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.p
 * JD-Core Version:    0.6.0
 */