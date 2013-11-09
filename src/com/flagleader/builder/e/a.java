package com.flagleader.builder.e;

import com.flagleader.builder.ResourceTools;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public abstract class a extends WizardPage
{
  public a(String paramString1, String paramString2, ImageDescriptor paramImageDescriptor)
  {
    super(paramString1, paramString2, paramImageDescriptor);
  }

  public a(String paramString)
  {
    super(paramString);
  }

  protected Button a(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 8);
    GridData localGridData = new GridData();
    localGridData.widthHint = 65;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.horizontalIndent = 16;
    localButton.setLayoutData(localGridData);
    return localButton;
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

  protected Composite a(Composite paramComposite, int paramInt1, int paramInt2, int paramInt3)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(paramInt3));
    localComposite.setLayoutData(a(paramInt1, paramInt2));
    return localComposite;
  }

  protected Composite a(Composite paramComposite, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Composite localComposite = new Composite(paramComposite, paramInt1);
    localComposite.setLayout(a(paramInt4));
    localComposite.setLayoutData(a(paramInt2, paramInt3));
    return localComposite;
  }

  protected Label a(Composite paramComposite, String paramString)
  {
    Label localLabel = new Label(paramComposite, 8519752);
    localLabel.setText(a(paramString, paramString));
    return localLabel;
  }

  protected Label b(Composite paramComposite)
  {
    Label localLabel = new Label(paramComposite, 8519752);
    return localLabel;
  }

  protected Label a(Composite paramComposite, String paramString, int paramInt1, int paramInt2)
  {
    Label localLabel = new Label(paramComposite, 25165896);
    localLabel.setText(a(paramString, paramString));
    localLabel.setLayoutData(a(paramInt1, paramInt2));
    return localLabel;
  }

  protected Label a(Composite paramComposite, int paramInt1, int paramInt2)
  {
    Label localLabel = new Label(paramComposite, 8519752);
    localLabel.setLayoutData(a(paramInt1, paramInt2));
    return localLabel;
  }

  protected void c(Composite paramComposite)
  {
    Label localLabel = new Label(paramComposite, 258);
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 3;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localLabel.setLayoutData(localGridData);
  }

  protected Button a(Composite paramComposite, String paramString, int paramInt)
  {
    Button localButton = new Button(paramComposite, paramInt);
    localButton.setText(a(paramString));
    return localButton;
  }

  protected Text b(Composite paramComposite, int paramInt1, int paramInt2, int paramInt3)
  {
    Text localText = new Text(paramComposite, paramInt1);
    if (paramInt3 <= 12)
      localText.setLayoutData(b(paramInt2));
    else
      localText.setLayoutData(a(paramInt2, paramInt3));
    return localText;
  }

  protected Text a(Composite paramComposite, int paramInt)
  {
    Text localText = new Text(paramComposite, paramInt);
    return localText;
  }

  protected Combo b(Composite paramComposite, int paramInt)
  {
    return new Combo(paramComposite, paramInt);
  }

  protected Combo c(Composite paramComposite, int paramInt1, int paramInt2, int paramInt3)
  {
    Combo localCombo = new Combo(paramComposite, paramInt1);
    localCombo.setLayoutData(a(paramInt2, paramInt3));
    return localCombo;
  }

  protected Combo d(Composite paramComposite)
  {
    return new Combo(paramComposite, 4);
  }

  protected Text b(Composite paramComposite, String paramString, int paramInt1, int paramInt2)
  {
    a(paramComposite, paramString);
    Text localText = a(paramComposite, paramInt1);
    for (int i = 2; i < paramInt2; i++)
      a(paramComposite, "");
    return localText;
  }

  protected Text a(Composite paramComposite, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramComposite, paramString);
    Text localText = b(paramComposite, paramInt1, paramInt2, paramInt3);
    for (int i = 2; i < paramInt4; i++)
      a(paramComposite, "");
    return localText;
  }

  protected Combo c(Composite paramComposite, String paramString, int paramInt1, int paramInt2)
  {
    a(paramComposite, paramString);
    Combo localCombo = b(paramComposite, paramInt1);
    for (int i = 2; i < paramInt2; i++)
      a(paramComposite, "");
    return localCombo;
  }

  protected Combo b(Composite paramComposite, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramComposite, paramString);
    Combo localCombo = c(paramComposite, paramInt1, paramInt2, paramInt3);
    for (int i = 2; i < paramInt4; i++)
      a(paramComposite, "");
    return localCombo;
  }

  protected String a(String paramString)
  {
    String str = ResourceTools.getMessage(paramString, paramString);
    return str;
  }

  protected String a(String paramString1, String paramString2)
  {
    String str = ResourceTools.getMessage(paramString1, paramString2);
    return str;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.a
 * JD-Core Version:    0.6.0
 */