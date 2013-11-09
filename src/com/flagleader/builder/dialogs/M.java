package com.flagleader.builder.dialogs;

import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.manager.c.a;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class M extends f
{
  private String a = "";
  private p b;
  private int c = 500;
  private int d = 400;
  private int e = 50;
  private int f = -1;
  private int g = 0;
  private a h = null;
  private int i = 0;

  public M(String paramString, int paramInt)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramString;
    this.g = paramInt;
    super.setShellStyle(66576);
  }

  public M(String paramString, int paramInt1, int paramInt2)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramString;
    this.g = paramInt1;
    this.i = paramInt2;
    super.setShellStyle(66576);
  }

  public M(String paramString, int paramInt, a parama)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramString;
    this.g = paramInt;
    if (parama != null)
      this.h = parama;
    super.setShellStyle(1168);
  }

  public M(Shell paramShell, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramShell);
    this.a = paramString;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt1;
    this.d = paramInt4;
    super.setShellStyle(66576);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    int j = 8391426;
    if ((this.i == 1) || (this.g == 4))
      j = 8456770;
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite.setLayout(localGridLayout);
    localComposite.setLayoutData(new GridData(1808));
    if (this.g == 1)
      this.b = s.a(1, this.h, localComposite, j);
    else if (this.g == 2)
      this.b = s.a(2, this.h, localComposite, j);
    else if (this.g == 3)
      this.b = s.a(3, this.h, localComposite, j);
    else if (this.g == 4)
      this.b = s.a(4, this.h, localComposite, j);
    else if (this.g == 5)
      this.b = s.a(5, this.h, localComposite, j);
    else if (this.g == 6)
      this.b = s.a(6, this.h, localComposite, j);
    else
      this.b = s.a(0, this.h, localComposite, j);
    this.b.a().setText(this.a);
    GridData localGridData = new GridData(this.c, this.d);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.b.a().setLayoutData(localGridData);
    return localComposite;
  }

  protected void okPressed()
  {
    this.a = this.b.a().getText();
    super.okPressed();
  }

  public String a()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.M
 * JD-Core Version:    0.6.0
 */