package com.flagleader.builder.shell;

import com.flagleader.builder.widget.a.X;
import com.flagleader.repository.export.Tag;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

class cA
{
  private Tag b;
  private X c;
  private Composite d;
  private boolean e = true;

  public cA(bX parambX, Tag paramTag, CTabFolder paramCTabFolder, boolean paramBoolean)
  {
    this.b = paramTag;
    this.e = paramBoolean;
    a(paramCTabFolder);
  }

  private Composite a(CTabFolder paramCTabFolder)
  {
    this.d = new Composite(paramCTabFolder, 0);
    this.d.setLayout(new GridLayout());
    this.d.setLayoutData(new GridData(1808));
    this.c = new X(this.d, 68162);
    this.c.m().addModifyListener(new cB(this));
    if (this.e)
      this.c.m().setText(this.b.getPreCode());
    else
      this.c.m().setText(this.b.getPostCode());
    return this.d;
  }

  public X a()
  {
    return this.c;
  }

  public Tag b()
  {
    return this.b;
  }

  public Composite c()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cA
 * JD-Core Version:    0.6.0
 */