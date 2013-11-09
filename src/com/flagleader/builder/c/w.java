package com.flagleader.builder.c;

import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;

class w
  implements ModifyListener
{
  w(v paramv, Text paramText)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    if (this.a.d.isLocked())
      return;
    if (!this.a.d.getDocument().equals(this.b.getText()))
    {
      this.a.d.setDocument(this.b.getText());
      this.a.d.setModified(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.w
 * JD-Core Version:    0.6.0
 */