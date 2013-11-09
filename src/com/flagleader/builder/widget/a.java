package com.flagleader.builder.widget;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class a extends Composite
{
  Label a;
  Composite b;
  Color c = h.d;

  public a(Composite paramComposite, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramComposite, paramInt3);
    GridData localGridData1 = new GridData();
    localGridData1.heightHint = paramInt2;
    setLayoutData(localGridData1);
    GridLayout localGridLayout1 = new GridLayout();
    localGridLayout1.numColumns = 1;
    localGridLayout1.marginHeight = 0;
    localGridLayout1.marginWidth = 0;
    localGridLayout1.horizontalSpacing = 0;
    localGridLayout1.verticalSpacing = 0;
    setLayout(localGridLayout1);
    this.b = new Composite(this, 0);
    GridData localGridData2 = new GridData();
    localGridData2.heightHint = (paramInt2 - 2);
    this.b.setLayoutData(localGridData2);
    GridLayout localGridLayout2 = new GridLayout();
    localGridLayout2.numColumns = 1;
    localGridLayout2.marginHeight = 1;
    localGridLayout2.marginWidth = 1;
    localGridLayout2.horizontalSpacing = 0;
    localGridLayout2.verticalSpacing = 0;
    this.b.setLayout(localGridLayout2);
    this.a = new Label(this.b, paramInt3);
    this.a.setLayoutData(new GridData(1808));
    this.a.setCursor(Display.getCurrent().getSystemCursor(21));
    this.a.addMouseTrackListener(new b(this));
  }

  public void a(Color paramColor)
  {
  }

  public void b(Color paramColor)
  {
    this.a.setBackground(paramColor);
  }

  public void setBackground(Color paramColor)
  {
    this.c = paramColor;
    this.b.setBackground(paramColor);
    super.setBackground(paramColor);
  }

  public void setFont(Font paramFont)
  {
    this.a.setFont(paramFont);
  }

  public void setForeground(Color paramColor)
  {
    this.a.setForeground(paramColor);
  }

  public void a()
  {
    this.b.setBackground(h.i);
  }

  public Label b()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.a.setText(paramString);
  }

  public String c()
  {
    return this.a.getText();
  }

  public void d()
  {
    this.b.setBackground(this.c);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a
 * JD-Core Version:    0.6.0
 */