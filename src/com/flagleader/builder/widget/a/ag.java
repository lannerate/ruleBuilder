package com.flagleader.builder.widget.a;

import com.flagleader.util.StringUtil;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;

class ag
  implements VerifyKeyListener
{
  ag(af paramaf)
  {
  }

  public void verifyKey(VerifyEvent paramVerifyEvent)
  {
    if ((paramVerifyEvent.keyCode == 9) && (this.a.e.getSelectionText() != null) && (this.a.e.getSelectionText().length() > 0))
    {
      String str = this.a.e.getSelectionText();
      if (str.indexOf(StringUtil.newline) > 0)
        str = StringUtil.replace(StringUtil.newline, StringUtil.newline + "\t", str);
      else if (str.indexOf("\n") > 0)
        str = StringUtil.replace("\n", "\n\t", str);
      str = "\t" + str;
      int i = this.a.e.getSelectionRange().x;
      this.a.e.replaceTextRange(i, this.a.e.getSelectionCount(), str);
      paramVerifyEvent.doit = false;
      this.a.e.setSelectionRange(i, str.length());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.ag
 * JD-Core Version:    0.6.0
 */