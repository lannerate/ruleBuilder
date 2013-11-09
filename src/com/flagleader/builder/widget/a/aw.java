package com.flagleader.builder.widget.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class aw extends af
{
  private au f;

  public aw(BuilderManager paramBuilderManager, Composite paramComposite, int paramInt)
  {
    super(paramBuilderManager, paramComposite, paramInt);
  }

  public aw(Composite paramComposite, int paramInt)
  {
    super(paramComposite, paramInt);
  }

  public void a(List paramList)
  {
    this.f.a(paramList);
  }

  protected StyledText a(Composite paramComposite, int paramInt)
  {
    StyledText localStyledText = super.a(paramComposite, paramInt);
    this.f = new au();
    localStyledText.addLineStyleListener(this.f);
    localStyledText.addModifyListener(new ax(this, localStyledText));
    localStyledText.addMouseListener(new ay(this, localStyledText));
    return localStyledText;
  }

  protected Menu i()
  {
    StyledText localStyledText = m();
    Menu localMenu = n();
    MenuItem localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("selectall.popup"));
    localMenuItem.addSelectionListener(new az(this, localStyledText));
    localMenuItem.setAccelerator(SWT.MOD1 + 65);
    if (localStyledText.getSelectionText().length() > 0)
    {
      localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("cut.popup"));
      localMenuItem.setAccelerator(SWT.MOD1 + 88);
      localMenuItem.addSelectionListener(new aA(this, localStyledText));
      localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("copy.popup"));
      localMenuItem.addSelectionListener(new aB(this, localStyledText));
      localMenuItem.setAccelerator(SWT.MOD1 + 67);
    }
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("paste.popup"));
    localMenuItem.addSelectionListener(new aC(this, localStyledText));
    localMenuItem.setAccelerator(SWT.MOD1 + 86);
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("setfont.popup"));
    localMenuItem.addSelectionListener(new aD(this));
    localMenu.setVisible(true);
    return localMenu;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= paramInt3 - 1)
      return paramInt3 - 1;
    if (m().getText(paramInt1, paramInt1).equals("("))
      return a(paramInt1 + 1, paramInt2 + 1, paramInt3);
    if (m().getText(paramInt1, paramInt1).equals(")"))
    {
      if (paramInt2 < 1)
        return paramInt1;
      return a(paramInt1 + 1, paramInt2 - 1, paramInt3);
    }
    return a(paramInt1 + 1, paramInt2, paramInt3);
  }

  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0)
      return paramInt1;
    if (m().getText(paramInt1, paramInt1).equals(")"))
      return a(paramInt1 - 1, paramInt2 + 1);
    if (m().getText(paramInt1, paramInt1).equals("("))
    {
      if (paramInt2 < 1)
        return paramInt1;
      return a(paramInt1 - 1, paramInt2 - 1);
    }
    return a(paramInt1 - 1, paramInt2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.aw
 * JD-Core Version:    0.6.0
 */