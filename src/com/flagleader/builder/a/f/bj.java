package com.flagleader.builder.a.f;

import com.flagleader.builder.a.aP;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bq;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.lang.a;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class bj extends aP
  implements bq, IElementViewer
{
  public bj(IRule paramIRule, Composite paramComposite, bu parambu)
  {
    super(paramIRule, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new bj((IRule)this.c, paramComposite, this.a);
  }

  private IRule e()
  {
    return (IRule)this.c;
  }

  protected p b(Composite paramComposite)
  {
    this.e = s.a(1, new bk(this), paramComposite, 68162);
    StyledText localStyledText = this.e.a();
    GridData localGridData = new GridData(1808);
    localGridData.horizontalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessVerticalSpace = true;
    localStyledText.setLayoutData(localGridData);
    localStyledText.setEditable(false);
    Color localColor = Display.getDefault().getSystemColor(29);
    localStyledText.setBackground(localColor);
    localStyledText.setForeground(Display.getDefault().getSystemColor(9));
    return this.e;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.e.a(m.a().f().a(e()));
    super.update();
  }

  protected void a(String paramString)
  {
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.c.getMaxModifyTime()) || (this.d < e().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "java";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bj
 * JD-Core Version:    0.6.0
 */