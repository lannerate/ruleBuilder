package com.flagleader.builder.dialogs;

import com.flagleader.builder.ResourceTools;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class r extends TitleAreaDialog
{
  protected r(Shell paramShell)
  {
    super(paramShell);
  }

  protected GridLayout a(int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    return localGridLayout;
  }

  protected GridData a(int paramInt1, int paramInt2)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt1;
    localGridData.heightHint = paramInt2;
    return localGridData;
  }

  protected GridData b(int paramInt)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt;
    return localGridData;
  }

  protected GridData c(int paramInt)
  {
    GridData localGridData = new GridData();
    localGridData.heightHint = paramInt;
    return localGridData;
  }

  protected Label a(Composite paramComposite)
  {
    Label localLabel = new Label(paramComposite, 25165896);
    return localLabel;
  }

  protected Label a(Composite paramComposite, String paramString)
  {
    Label localLabel = new Label(paramComposite, 25165896);
    localLabel.setText(paramString);
    return localLabel;
  }

  protected void b(Composite paramComposite)
  {
    Label localLabel = new Label(paramComposite, 258);
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 3;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localLabel.setLayoutData(localGridData);
  }

  protected Button a(Composite paramComposite, int paramInt)
  {
    Button localButton = new Button(paramComposite, paramInt);
    return localButton;
  }

  protected Text a(Composite paramComposite, int paramInt1, int paramInt2, int paramInt3)
  {
    Text localText = new Text(paramComposite, paramInt1);
    if (paramInt3 <= 12)
      localText.setLayoutData(b(paramInt2));
    else
      localText.setLayoutData(a(paramInt2, paramInt3));
    return localText;
  }

  protected Text b(Composite paramComposite, int paramInt)
  {
    Text localText = new Text(paramComposite, paramInt);
    return localText;
  }

  protected Combo a(Composite paramComposite, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramComposite, paramString);
    Combo localCombo = b(paramComposite, paramInt1, paramInt2, paramInt3);
    for (int i = 2; i < paramInt4; i++)
      a(paramComposite, "");
    return localCombo;
  }

  protected Combo b(Composite paramComposite, int paramInt1, int paramInt2, int paramInt3)
  {
    Combo localCombo = new Combo(paramComposite, paramInt1);
    localCombo.setLayoutData(a(paramInt2, paramInt3));
    return localCombo;
  }

  protected String a(String paramString)
  {
    return ResourceTools.getMessage(paramString);
  }

  protected String a(String paramString1, String paramString2)
  {
    return ResourceTools.getMessage(paramString1, paramString2);
  }

  protected void createButtonsForButtonBar(Composite paramComposite)
  {
    createButton(paramComposite, 0, a("Ok"), true);
    createButton(paramComposite, 1, a("Cancel"), false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.r
 * JD-Core Version:    0.6.0
 */