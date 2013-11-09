package com.flagleader.builder.a.b;

import com.flagleader.builder.a.aP;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bq;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.xml.TreeValue;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class aN extends aP
  implements bq, IElementViewer
{
  public aN(TreeValueNode paramTreeValueNode, Composite paramComposite, bu parambu)
  {
    super(paramTreeValueNode, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new aN((TreeValueNode)this.c, paramComposite, this.a);
  }

  private TreeValueNode e()
  {
    return (TreeValueNode)this.c;
  }

  protected p b(Composite paramComposite)
  {
    this.e = s.a(7, new aO(this), paramComposite, 68162);
    StyledText localStyledText = this.e.a();
    GridData localGridData = new GridData(1808);
    localGridData.horizontalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessVerticalSpace = true;
    localStyledText.setLayoutData(localGridData);
    localStyledText.setEditable(true);
    Color localColor = Display.getDefault().getSystemColor(29);
    localStyledText.setBackground(localColor);
    localStyledText.setForeground(Display.getDefault().getSystemColor(2));
    return this.e;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    TreeValue localTreeValue = e().getTreeValueStatic();
    if (localTreeValue != null)
      this.e.a(localTreeValue.toXml());
    else
      this.e.a(e().getFormatXml());
    super.update();
  }

  protected void a(String paramString)
  {
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.c.getModifyTime());
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "xml";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aN
 * JD-Core Version:    0.6.0
 */