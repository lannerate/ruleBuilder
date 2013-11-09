package com.flagleader.builder.widget.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;

class t
  implements VerifyKeyListener
{
  t(s params, StyledText paramStyledText)
  {
  }

  public void verifyKey(VerifyEvent paramVerifyEvent)
  {
    if ((paramVerifyEvent.keyCode == 9) && (this.b.getSelectionText() != null) && (this.b.getSelectionText().length() > 0))
    {
      StringBuffer localStringBuffer1 = new StringBuffer(this.b.getSelectionText());
      String[] arrayOfString = localStringBuffer1.toString().split("\\n");
      StringBuffer localStringBuffer2 = new StringBuffer();
      for (int i = 0; i < arrayOfString.length; i++)
        if ((paramVerifyEvent.stateMask & SWT.MOD2) != 0)
        {
          if (arrayOfString[i].startsWith("\t"))
            localStringBuffer2.append(arrayOfString[i].substring(1)).append("\n");
          else if (arrayOfString[i].startsWith("  "))
            localStringBuffer2.append(arrayOfString[i].substring(2)).append("\n");
          else
            localStringBuffer2.append(arrayOfString[i]).append("\n");
        }
        else
        {
          if (arrayOfString[i].length() <= 0)
            continue;
          localStringBuffer2.append("\t").append(arrayOfString[i]).append("\n");
        }
      i = this.b.getSelectionRange().x;
      this.b.replaceTextRange(i, this.b.getSelectionCount(), localStringBuffer2.toString());
      this.b.setSelectionRange(i, localStringBuffer2.length());
      paramVerifyEvent.doit = false;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.t
 * JD-Core Version:    0.6.0
 */