package com.flagleader.builder.dialogs.method;

import com.flagleader.builder.ResourceTools;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class I
{
  Shell a;
  Text b;
  Combo c;
  Label d;
  Button e;
  Button f;
  Button g;
  Button h;
  Button i;
  e j;

  public I(Shell paramShell)
  {
    this.a = new Shell(paramShell, 2144);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 2;
    this.a.setLayout(localGridLayout);
    this.a.setText(ResourceTools.getMessage("title.SearchDialog"));
    this.a.addShellListener(new J(this));
    Label localLabel = new Label(this.a, 16384);
    localLabel.setText(ResourceTools.getMessage("find_what.SearchDialog"));
    this.b = new Text(this.a, 2048);
    GridData localGridData = new GridData(768);
    localGridData.widthHint = 200;
    this.b.setLayoutData(localGridData);
    this.b.addModifyListener(new K(this));
    this.d = new Label(this.a, 16384);
    this.c = new Combo(this.a, 12);
    localGridData = new GridData(768);
    localGridData.widthHint = 200;
    this.c.setLayoutData(localGridData);
    this.e = new Button(this.a, 32);
    this.e.setText(ResourceTools.getMessage("match_case.SearchDialog"));
    localGridData = new GridData();
    localGridData.horizontalSpan = 2;
    this.e.setLayoutData(localGridData);
    this.f = new Button(this.a, 32);
    this.f.setText(ResourceTools.getMessage("match_word.SearchDialog"));
    localGridData = new GridData();
    localGridData.horizontalSpan = 2;
    this.f.setLayoutData(localGridData);
    this.g = new Button(this.a, 32);
    this.g.setText(ResourceTools.getMessage("onlyshow.RuleLogViewer"));
    localGridData = new GridData();
    localGridData.horizontalSpan = 2;
    this.g.setLayoutData(localGridData);
    Group localGroup = new Group(this.a, 0);
    localGridData = new GridData();
    localGridData.horizontalSpan = 2;
    localGroup.setLayoutData(localGridData);
    localGroup.setLayout(new FillLayout());
    localGroup.setText(ResourceTools.getMessage("direction.SearchDialog"));
    Button localButton1 = new Button(localGroup, 16);
    localButton1.setText(ResourceTools.getMessage("dir_up.SearchDialog"));
    localButton1.setSelection(false);
    this.i = new Button(localGroup, 16);
    this.i.setText(ResourceTools.getMessage("dir_down.SearchDialog"));
    this.i.setSelection(true);
    Composite localComposite = new Composite(this.a, 0);
    localGridData = new GridData(256);
    localGridData.horizontalSpan = 2;
    localComposite.setLayoutData(localGridData);
    localGridLayout = new GridLayout();
    localGridLayout.numColumns = 2;
    localGridLayout.makeColumnsEqualWidth = true;
    localComposite.setLayout(localGridLayout);
    this.h = new Button(localComposite, 8);
    this.h.setText(ResourceTools.getMessage("find.SearchDialog"));
    this.h.setLayoutData(new GridData(128));
    this.h.setEnabled(false);
    this.h.addSelectionListener(new L(this));
    Button localButton2 = new Button(localComposite, 8);
    localButton2.setText(ResourceTools.getMessage("Cancel.SearchDialog"));
    localButton2.setLayoutData(new GridData(32));
    localButton2.addSelectionListener(new M(this));
    this.a.pack();
  }

  public String a(String paramString)
  {
    return this.d.getText();
  }

  public String[] a()
  {
    return this.c.getItems();
  }

  public boolean b()
  {
    return this.e.getSelection();
  }

  public boolean c()
  {
    return this.f.getSelection();
  }

  public boolean d()
  {
    return this.g.getSelection();
  }

  public String e()
  {
    return this.b.getText();
  }

  public boolean f()
  {
    return this.i.getSelection();
  }

  public int g()
  {
    return this.c.getSelectionIndex();
  }

  public void h()
  {
    if (this.a.isVisible())
      this.a.setFocus();
    else
      this.a.open();
    this.b.setFocus();
  }

  public void a(String[] paramArrayOfString)
  {
    for (int k = 0; k < paramArrayOfString.length; k++)
      this.c.add(paramArrayOfString[k]);
    this.c.select(0);
  }

  public void b(String paramString)
  {
    this.d.setText(paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.e.setSelection(paramBoolean);
  }

  public void b(boolean paramBoolean)
  {
    this.f.setSelection(paramBoolean);
  }

  public void c(boolean paramBoolean)
  {
    this.i.setSelection(paramBoolean);
  }

  public void c(String paramString)
  {
    this.b.setText(paramString);
  }

  public void a(int paramInt)
  {
    this.c.select(paramInt);
  }

  public void a(e parame)
  {
    this.j = parame;
  }

  public void b(e parame)
  {
    this.j = null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.I
 * JD-Core Version:    0.6.0
 */